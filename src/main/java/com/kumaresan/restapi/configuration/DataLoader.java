package com.kumaresan.restapi.configuration;

import com.kumaresan.restapi.entities.City;
import com.kumaresan.restapi.entities.Country;
import com.kumaresan.restapi.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final CountryRepository countryRepository;

    @Override
    public void run(String... args) {

        // Prevent duplicate insertion
        if (countryRepository.count() > 0) {
            return;
        }

        // USA
        Country usa = new Country();
        usa.setName("USA");

        City ny = new City();
        ny.setName("New York");
        ny.setCountry(usa);

        City la = new City();
        la.setName("Los Angeles");
        la.setCountry(usa);

        usa.setCities(List.of(ny, la));

        // India
        Country india = new Country();
        india.setName("India");

        City mumbai = new City();
        mumbai.setName("Mumbai");
        mumbai.setCountry(india);

        City delhi = new City();
        delhi.setName("Delhi");
        delhi.setCountry(india);

        india.setCities(List.of(mumbai, delhi));

        // Germany
        Country germany = new Country();
        germany.setName("Germany");

        City berlin = new City();
        berlin.setName("Berlin");
        berlin.setCountry(germany);

        City munich = new City();
        munich.setName("Munich");
        munich.setCountry(germany);

        germany.setCities(List.of(berlin, munich));

        countryRepository.saveAll(List.of(usa, india, germany));

        System.out.println("✅ Default Countries and Cities Loaded");
    }
}
