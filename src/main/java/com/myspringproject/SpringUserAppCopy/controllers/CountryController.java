package com.myspringproject.SpringUserAppCopy.controllers;

import com.myspringproject.SpringUserAppCopy.entities.Country;
import com.myspringproject.SpringUserAppCopy.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CountryController {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping("/countries")
    public String getCountries(Model model){
        List<Country> countriesList = countryRepository.findAll();
        model.addAttribute("countries", countriesList);
        return "countries";
    }
}
