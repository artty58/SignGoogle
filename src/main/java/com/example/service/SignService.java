package com.example.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class SignService {

    public ResponseEntity<String> save(String json) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Content.Type", "application/json; charset=utf-8");
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/savesign";

        HttpEntity<String> entity = new HttpEntity<>(json, headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        return responseEntity;

    }

    public ResponseEntity<String> findByUser(String email) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Content.Type", "application/json; charset=utf-8");
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8100/SignBack/findByUser?email="+email;

        HttpEntity<String> entity = new HttpEntity<>("", headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return responseEntity;
    }
}
