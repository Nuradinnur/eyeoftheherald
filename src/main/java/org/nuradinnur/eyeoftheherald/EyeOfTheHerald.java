package org.nuradinnur.eyeoftheherald;

import lombok.val;
import org.nuradinnur.eyeoftheherald.constant.Regions;
import org.nuradinnur.eyeoftheherald.service.DataCrawlingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EyeOfTheHerald {

    public static void main(String... args) {
        val context = SpringApplication.run(EyeOfTheHerald.class, args);

//        val crawler = context.getBean(DataCrawlingService.class);
//        for (val region : Regions.values()) {
//            if (region != Regions.PBE) {
//                crawler.start(region);
//            }
//        }
    }
}
