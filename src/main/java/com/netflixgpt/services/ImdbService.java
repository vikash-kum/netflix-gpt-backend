package com.netflixgpt.services;

import com.netflixgpt.exception.CommonException;
import com.netflixgpt.utility.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ImdbService {

   private final Constants constants;

    public ResponseEntity<?> nowPlayingTMDBApi(String url) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", constants.TMDB_TOKEN);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create an HttpEntity with headers
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<?> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                String.class
        );

        // Handle the response as needed
        if (response.getStatusCode() == HttpStatus.OK) {
            return response;
        } else {
            throw new CommonException("Internal Server Error");

        }
    }


}
