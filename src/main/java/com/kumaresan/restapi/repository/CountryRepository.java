package com.kumaresan.restapi.repository;

import com.kumaresan.restapi.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
