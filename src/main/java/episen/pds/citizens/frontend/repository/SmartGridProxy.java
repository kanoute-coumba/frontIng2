package episen.pds.citizens.frontend.repository;

import episen.pds.citizens.frontend.CustomProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SmartGridProxy {
    @Autowired
    private static CustomProperties props = new CustomProperties();

    public Double smartgrid() {
        String url = props.getApiUrl() + "/smartgrid";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Double> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );

        return response.getBody();
    }
}
