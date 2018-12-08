package org.nuradinnur.eyeoftheherald.repository;

import org.nuradinnur.eyeoftheherald.domain.collected.clean.match.CompletedMatch;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompletedMatchRepository extends PagingAndSortingRepository<CompletedMatch, Long> {
}
