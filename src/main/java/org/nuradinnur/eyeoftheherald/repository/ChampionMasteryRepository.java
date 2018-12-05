package org.nuradinnur.eyeoftheherald.repository;

import org.nuradinnur.eyeoftheherald.domain.collected.clean.championmastery.ChampionMastery;
import org.nuradinnur.eyeoftheherald.domain.collected.clean.championmastery.ChampionMasteryId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryDefinition(domainClass = ChampionMastery.class, idClass = ChampionMasteryId.class)
public interface ChampionMasteryRepository extends PagingAndSortingRepository<ChampionMastery, ChampionMasteryId> {
    @Query("select sum(mastery.championLevel) from ChampionMastery mastery where mastery.summonerId = :summonerId")
    Integer findMasteryScoreForSummoner(Long summonerId);
}
