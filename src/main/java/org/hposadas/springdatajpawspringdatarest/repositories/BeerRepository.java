package org.hposadas.springdatajpawspringdatarest.repositories;

import org.hposadas.springdatajpawspringdatarest.domain.Beer;
import org.hposadas.springdatajpawspringdatarest.domain.BeerStyleEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(path = "beer", collectionResourceRel = "Array Of All Beer Objects")
public interface BeerRepository extends JpaRepository<Beer, UUID> {

    Page<Beer> findAllByBeerName(String beerName, Pageable pageable);
    Page<Beer> findAllByBeerStyle(BeerStyleEnum beerStyle, Pageable pageable);
    Page<Beer> findAllByBeerNameAndBeerStyle(
            String beerName,
            BeerStyleEnum beerStyle,
            Pageable pageable
    );
    Beer findByUpc(String upc);
}
