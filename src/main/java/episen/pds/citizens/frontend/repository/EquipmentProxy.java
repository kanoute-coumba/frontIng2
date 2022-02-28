package episen.pds.citizens.frontend.repository;

import episen.pds.citizens.frontend.CustomProperties;
import episen.pds.citizens.frontend.model.Equipment;
import episen.pds.citizens.frontend.model.EquipmentWithConsumption;
import episen.pds.citizens.frontend.model.House;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Slf4j
@Component
public class EquipmentProxy {

    @Autowired
    private static final CustomProperties props = new CustomProperties();
    private static final Logger logger = Logger.getLogger(EquipmentProxy.class.getName());

    public static Iterable<EquipmentWithConsumption> getEquipmentWithConsumptionByBuilding(int id_b) {
        String baseApiUrl = props.getApiUrl();
        String getEquipWithConsumptionUrl = baseApiUrl + "/EquipmentOrderByConsumption/idb=" + id_b;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<EquipmentWithConsumption>> response = restTemplate.exchange(
                getEquipWithConsumptionUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        logger.info("Get EquipmentWithConsumptionByBuilding call " + response.getStatusCode());

        return response.getBody();
    }

    public static Iterable<EquipmentWithConsumption> getEquipmentWithConsumptionByRoom(int id_r) {
        String baseApiUrl = props.getApiUrl();
        String getEquipWithConsumptionUrl = baseApiUrl + "/EquipmentOrderByConsumption/idr=" + id_r;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<EquipmentWithConsumption>> response = restTemplate.exchange(
                getEquipWithConsumptionUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        logger.info("Get EquipmentWithConsumptionByRoom call " + response.getStatusCode());

        return response.getBody();
    }

    public static Iterable<Equipment> getEquipmentByRoom(Integer idr) {
        String baseApiUrl = props.getApiUrl();
        String getEquipmentUrl = baseApiUrl + "/equipmentBYRoom/" + idr;

        System.out.println(getEquipmentUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Equipment>> response = restTemplate.exchange(
                getEquipmentUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Equipment>>() {
                }
        );

        logger.info("Get equipmentByRoom " + response.getStatusCode().toString());

        return response.getBody();

    }

    public static void updateStatutMode(String chooseStatut, String type_mode, Integer id_equipment) {
        System.out.println("oooooooooooo");
        String baseApiUrl = props.getApiUrl();
        String getEquipmentUrl = baseApiUrl + "/choosestatut?chooseStatut=" + chooseStatut + "&type_mode=" + type_mode + "&id_equipment=" + id_equipment;

        System.out.println(getEquipmentUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                getEquipmentUrl,
                HttpMethod.PUT,
                null,
                new ParameterizedTypeReference<String>() {
                }
        );

        logger.info("Get Equipment call " + response.getStatusCode().toString());
    }

    public static String getNameRoomByIdroom(Integer id_room) {
        System.out.println("oooooooooooo");
        String baseApiUrl = props.getApiUrl();
        String getEquipmentUrl = baseApiUrl + "/nameRoom?id_room=" + id_room;

        System.out.println(getEquipmentUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                getEquipmentUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<String>() {
                }
        );

        logger.info("Get Equipment call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public static String NameEquipment(Integer id_equipment) {

        String baseApiUrl = props.getApiUrl();
        String getEquipmentUrl = baseApiUrl + "/nameEquipment?id_equipment=" + id_equipment;


        System.out.println(getEquipmentUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                getEquipmentUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<String>() {
                }
        );

        logger.info("Get Equipment call " + response.getStatusCode().toString());
        System.out.println("fin de nameEquipment");

        return response.getBody();

    }

    public static void updateValueEquipment(Integer valueEquipment, Integer id_equipment) {

        String baseApiUrl = props.getApiUrl();
        String getEquipmentUrl = baseApiUrl + "/valueEquipment?valueEquipment=" + valueEquipment + "&id_equipment=" + id_equipment;

        System.out.println(getEquipmentUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                getEquipmentUrl,
                HttpMethod.PUT,
                null,
                new ParameterizedTypeReference<String>() {
                }
        );

        logger.info("Get Equipment call " + response.getStatusCode().toString());
    }

    public static Integer getIdRoomByEquipment(Integer id_equipment) {
        String baseApiUrl = props.getApiUrl();
        String getEquipmentUrl = baseApiUrl + "/getIdRoomByEquipment?id_equipment=" + id_equipment;

        System.out.println(getEquipmentUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Integer> response = restTemplate.exchange(
                getEquipmentUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Integer>() {
                }
        );

        logger.info("Get id room " + response.getStatusCode().toString());

        return response.getBody();
    }

    public static Iterable<House> getBuildingsByUser(String email) {
        String baseApiUrl = props.getApiUrl();
        String getEquipmentUrl = baseApiUrl + "/house?email=" + email;
        System.out.println(getEquipmentUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<House>> response = restTemplate.exchange(
                getEquipmentUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        logger.info("Get buildings " + response.getStatusCode());

        return response.getBody();

    }
}
