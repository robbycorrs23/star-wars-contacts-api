package com.example.starwarscontacts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SwapiService {
    private static final String SWAPI_BASE_URL = "https://swapi.dev/api/";
    private final RestTemplate restTemplate;

    @Autowired
    public SwapiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String searchCharacter(String name) {
        String url = SWAPI_BASE_URL + "people/?search=" + name;
        return restTemplate.getForObject(url, String.class);
    }
}
