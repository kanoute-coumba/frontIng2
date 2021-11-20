package episen.pds.citizens.frontend.repository;

import episen.pds.citizens.frontend.CustomProperties;
import episen.pds.citizens.frontend.model.ConsumptionByBuilding;
import episen.pds.citizens.frontend.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class UseMonitorProxy {
    @Autowired
    private static CustomProperties props = new CustomProperties();

    public static Iterable<ConsumptionByBuilding> getConsumptionByBuilding() {
        String baseApiUrl = props.getApiUrl();
        String getConsBuildUrl = baseApiUrl + "/getConsumptionByBuilding";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<ConsumptionByBuilding>> response = restTemplate.exchange(
                getConsBuildUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<ConsumptionByBuilding>>() {
                }
        );
        return response.getBody();
    }
}
