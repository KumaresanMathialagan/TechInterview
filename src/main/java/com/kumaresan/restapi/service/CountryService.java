package com.kumaresan.restapi.service;


import com.kumaresan.restapi.entities.City;
import com.kumaresan.restapi.entities.Country;
import com.kumaresan.restapi.repository.CityRepository;
import com.kumaresan.restapi.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;

    public Country saveCountry(Country country) {
        country.getCities().forEach(city -> city.setCountry(country));
        return countryRepository.save(country);
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public List<City> getCitiesByCountry(Long countryId) {
        return cityRepository.findByCountryId(countryId);
    }
}
