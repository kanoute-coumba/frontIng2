package episen.pds.citizens.frontend.repository;

import episen.pds.citizens.frontend.CustomProperties;
import episen.pds.citizens.frontend.model.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class BuildingProxy {

    @Autowired
    private static CustomProperties props = new CustomProperties();

    public Iterable<Building> getBuildings() {
        String url = props.getApiUrl() + "/buildings";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Building>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );

        return response.getBody();
    }
}
