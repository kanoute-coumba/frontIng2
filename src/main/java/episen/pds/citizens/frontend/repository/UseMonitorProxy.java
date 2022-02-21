package episen.pds.citizens.frontend.repository;

import episen.pds.citizens.frontend.CustomProperties;
import episen.pds.citizens.frontend.controllers.UseMonitorController;
import episen.pds.citizens.frontend.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Slf4j
@Component
public class UseMonitorProxy {
    @Autowired
    private static CustomProperties props = new CustomProperties();
    private static final Logger logger = Logger.getLogger(UseMonitorProxy.class.getName());

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
        String getConsBuildUrl = baseApiUrl + "/getEquipmentsByRoom/" + id_room;

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

    public Iterable<Equipment> getAllEquipments() {
        String baseApiUrl = props.getApiUrl();
        String getConsBuildUrl = baseApiUrl + "/getAllEquipments";
        logger.info(getConsBuildUrl);
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

    public RoomConditions getConditionsInRoom(int id_room) {
        String baseApiUrl = props.getApiUrl();
        String getConsBuildUrl = baseApiUrl + "/getLastConditions/" + id_room;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RoomConditions> response = restTemplate.exchange(
                getConsBuildUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        return response.getBody();
    }

    public Iterable<Room> getRooms() {
        String baseApiUrl = props.getApiUrl();
        String getConsBuildUrl = baseApiUrl + "/getAllRooms";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Room>> response = restTemplate.exchange(
                getConsBuildUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        return response.getBody();
    }

    public void setEquipmentValue(int id_equipment, double value) {
        String baseApiUrl = props.getApiUrl();
        String getConsBuildUrl = baseApiUrl + "/setEquipment/"+id_equipment+"/"+value;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                getConsBuildUrl,
                HttpMethod.POST,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
    }

    public void setEquipmentAuto(int id_equipment) {
        String baseApiUrl = props.getApiUrl();
        String getConsBuildUrl = baseApiUrl + "/setEquipmentAuto/"+id_equipment;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                getConsBuildUrl,
                HttpMethod.POST,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
    }

    public void setEquipmentManu(int id_equipment) {
        String baseApiUrl = props.getApiUrl();
        String getConsBuildUrl = baseApiUrl + "/setEquipmentManu/"+id_equipment;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                getConsBuildUrl,
                HttpMethod.POST,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
    }

    public void setEquipmentOff(int id_equipment) {
        String baseApiUrl = props.getApiUrl();
        String getConsBuildUrl = baseApiUrl + "/setEquipmentOff/"+id_equipment;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                getConsBuildUrl,
                HttpMethod.POST,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
    }

    public void setEquipmentOn(int id_equipment) {
        String baseApiUrl = props.getApiUrl();
        String getConsBuildUrl = baseApiUrl + "/setEquipmentOn/"+id_equipment;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                getConsBuildUrl,
                HttpMethod.POST,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
    }
}
