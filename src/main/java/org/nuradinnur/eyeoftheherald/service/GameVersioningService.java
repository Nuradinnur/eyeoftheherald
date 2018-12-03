package org.nuradinnur.eyeoftheherald.service;

import lombok.Getter;
import lombok.val;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.nuradinnur.eyeoftheherald.configuration.DataAccessConfiguration;
import org.nuradinnur.eyeoftheherald.constant.DataDragonFiles;
import org.nuradinnur.eyeoftheherald.constant.Endpoints;
import org.nuradinnur.eyeoftheherald.constant.Locales;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class GameVersioningService {

    private final Logger logger;
    private final RestTemplate rest;
    private final DataAccessConfiguration dataAccessConfiguration;

    private final Pattern deversioningPattern = Pattern.compile("^\\d+\\.\\d+");

    @Getter
    private String currentGameVersion;
    private String currentGamePatch;

    public GameVersioningService(RestTemplate rest, DataAccessConfiguration dataAccessConfiguration) {
        this.logger = LoggerFactory.getLogger(this.getClass());
        this.rest = rest;
        this.dataAccessConfiguration = dataAccessConfiguration;
    }

    @PostConstruct
    private void initialize() throws IOException {
        checkForUpdates();
    }

    public boolean isCurrentPatch(String gameVersion) {
        if (gameVersion.startsWith(currentGamePatch)) {
            return true;
        }
        return false;
    }

    public Path getDataDragonDefinitionPath(Locales locale, DataDragonFiles dataDragonFile) {
        return Paths.get(getDataDragonFolder().toString(),
                currentGameVersion,
                "data",
                locale.getIdentifier(),
                dataDragonFile.getFileName());
    }

    public Path getDataDragonFolder() {
        return Paths.get(System.getProperty("user.dir"), "static", "datadragon");
    }

    @Scheduled(fixedDelay = 60 * 60 * 1000, initialDelay = 60 * 60 * 1000)
    private void checkForUpdates() throws IOException {
        logger.info("Checking for Data Dragon definition updates...");
        val latestGameVersion = getLatestGameVersion();
        if (!(currentGameVersion == null) && currentGameVersion.equals(latestGameVersion)) {
            logger.info("Data Dragon definitions are up to date.");
        }
        if (currentGameVersion == null || !currentGameVersion.equals(latestGameVersion)) {
            this.currentGameVersion = latestGameVersion;
            val deversioningMatcher = deversioningPattern.matcher(this.currentGameVersion);
            deversioningMatcher.find();
            this.currentGamePatch = deversioningMatcher.group();
            val tarballPath = getGameDefinitionsAsTarball(latestGameVersion);
            if (tarballPath != null) {
                // TODO: Throw exception if null
                decompressTarball(tarballPath);
            }
            logger.info("Successfully updated Data Dragon definitions to version {}.", currentGameVersion);
        }
    }

    private String getLatestGameVersion() {
        val pathParameters = new HashMap<String, String>();
        val uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host(dataAccessConfiguration.getDataDragonUriPrefix())
                .path(Endpoints.GAME_VERSIONS.getPattern())
                .buildAndExpand(pathParameters)
                .toUri();
        val response = rest.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {
        });
        return response.getBody().get(0);
    }

    private Path getGameDefinitionsAsTarball(String gameVersion) throws IOException {
        logger.info("Checking directory integrity.");
        val definitionsDirectory = getDataDragonFolder();
        val tarballPath = Paths.get(definitionsDirectory.toString(), "dragontail_" + gameVersion + ".tgz");

        Files.createDirectories(definitionsDirectory);
        val definitionsAreDownloaded = Files.find(definitionsDirectory, 1, (file, attr) ->
                file.getFileName().toString().startsWith(currentGameVersion)).findAny().isPresent();

        if (definitionsAreDownloaded) {
            return null;
        }

        getDefinitionsTarball(gameVersion, tarballPath);
        return tarballPath;
    }

    private void getDefinitionsTarball(String gameVersion, Path path) {
        logger.info("Downloading Data Dragon tarball...");
        val pathParameters = new HashMap<String, String>();
        pathParameters.put("gameVersion", gameVersion);
        val uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host(dataAccessConfiguration.getDataDragonUriPrefix())
                .path(Endpoints.STATIC_DATA_TARBALL.getPattern())
                .buildAndExpand(pathParameters)
                .toUri();
        RequestCallback requestCallback = request ->
                request.getHeaders()
                        .setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM, MediaType.ALL));
        ResponseExtractor<Void> responseExtractor = response -> {
            Files.copy(response.getBody(), path);
            return null;
        };
        rest.execute(uri, HttpMethod.GET, requestCallback, responseExtractor);
    }

    private void decompressTarball(Path path) throws IOException {
        logger.info("Decompressing {}...", path.toFile().getName());
        val tgzInputStream = new TarArchiveInputStream(
                new GzipCompressorInputStream(
                        new BufferedInputStream(
                                new FileInputStream(path.toFile()))));

        TarArchiveEntry entry;
        while ((entry = tgzInputStream.getNextTarEntry()) != null) {
            if (entry.isDirectory()) {
                continue;
            }
            val currentFile = new File(path.toFile().getParentFile(), entry.getName());
            val parent = currentFile.getParentFile();
            if (!parent.exists()) {
                parent.mkdirs();
            }
            IOUtils.copy(tgzInputStream, new FileOutputStream(currentFile));
        }

        path.toFile().delete();
    }
}
