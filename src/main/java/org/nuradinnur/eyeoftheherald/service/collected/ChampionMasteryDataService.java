package org.nuradinnur.eyeoftheherald.service.collected;

import org.nuradinnur.eyeoftheherald.component.DataCollectionInterface;
import org.springframework.data.repository.PagingAndSortingRepository;

abstract class AbstractDataService<T, U> {

    private final DataCollectionInterface dataCollectionInterface;
    private final PagingAndSortingRepository<T, U> repository;

    AbstractDataService(DataCollectionInterface dataCollectionInterface, PagingAndSortingRepository repository) {
        this.dataCollectionInterface = dataCollectionInterface;
        this.repository = repository;
    }
}
