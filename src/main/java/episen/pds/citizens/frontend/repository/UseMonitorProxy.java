package episen.pds.citizens.frontend.repository;

import episen.pds.citizens.frontend.CustomProperties;
import episen.pds.citizens.frontend.model.ConsumptionByBuilding;
import episen.pds.citizens.frontend.model.Equipment;
import episen.pds.citizens.frontend.model.RoomsWithConsumption;
import episen.pds.citizens.frontend.model.Test;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
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
                new ParameterizedTypeReference<>() {
                }
        );
        return response.getBody();
    }

    public Iterable<RoomsWithConsumption> getRoomsWithConsumption() {
        String baseApiUrl = props.getApiUrl();
        String getConsBuildUrl = baseApiUrl + "/getRoomsWithConsumption";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<RoomsWithConsumption>> response = restTemplate.exchange(
                getConsBuildUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        return response.getBody();
    }

    public Iterable<Equipment> getEquipmentByRoom(int id_room) {
        String baseApiUrl = props.getApiUrl();
        String getConsBuildUrl = baseApiUrl + "/getEquipmentsByRoom?id_room=" + id_room;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Equipment>> response = restTemplate.exchange(
                getConsBuildUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        return response.getBody();
    }
}
