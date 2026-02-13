package com.kumaresan.restapi.controllers;


import com.kumaresan.restapi.entities.City;
import com.kumaresan.restapi.entities.Country;
import com.kumaresan.restapi.service.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
@CrossOrigin(origins = "http://localhost:4200")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    // 1️⃣ Add country with cities
    @PostMapping("/countries")
    public Country addCountry(@RequestBody Country country) {
        return countryService.saveCountry(country);
    }

    // 2️⃣ Get all countries
    @GetMapping("/countries")
    public List<Country> getCountries() {
        return countryService.getAllCountries();
    }

    // 3️⃣ Get cities by country
    @GetMapping("/countries/{id}/cities")
    public List<City> getCitiesByCountry(@PathVariable Long id) {
        return countryService.getCitiesByCountry(id);
    }
}
