package episen.pds.citizens.frontend.repository;

import episen.pds.citizens.frontend.CustomProperties;
import episen.pds.citizens.frontend.model.Equipment;
import episen.pds.citizens.frontend.model.EquipmentWithConsumption;

import episen.pds.citizens.frontend.model.architectureModel.Building;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
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

    public static Iterable<Map<String, String>> getEquipmentByRoom(Integer idr) {
        String baseApiUrl = props.getApiLocalUrl();
        String getEquipmentUrl = baseApiUrl + "/equipmentBYRoom/" + idr;

        System.out.println(getEquipmentUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Map<String, String>>> response = restTemplate.exchange(
                getEquipmentUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Map<String, String>>>() {
                }
        );
        logger.info(response.toString() + "les équipements");

        logger.info("Get equipmentByRoom " + response.getStatusCode().toString());

        return response.getBody();

    }

    public static void updateStatutMode(String chooseStatut, String type_mode, Integer id_equipment) {
        System.out.println("oooooooooooo");
        String baseApiUrl = props.getApiLocalUrl();
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
        String baseApiUrl = props.getApiLocalUrl();
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

        String baseApiUrl = props.getApiLocalUrl();
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

        String baseApiUrl = props.getApiLocalUrl();
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
        String baseApiUrl = props.getApiLocalUrl();
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

    public static Iterable<Building> getBuildingsByUser(String email) {
        String baseApiUrl = props.getApiLocalUrl();
        String getEquipmentUrl = baseApiUrl + "/house?email=" + email;
        System.out.println(getEquipmentUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Building>> response = restTemplate.exchange(
                getEquipmentUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        logger.info("Get buildings " + response.getStatusCode());
        System.out.println(response.getBody().toString());
        return response.getBody();

    }

    public static void updateStatutAuto(String type_mode, Integer id_equipment) {
        logger.info("j'entre dans la méthode");
        System.out.println(type_mode + "proxy");



        String baseApiUrl = props.getApiLocalUrl();
        String getEquipmentUrl = baseApiUrl + "/updateAuto?type_mode=" + type_mode +"&id_equipment=" + id_equipment;


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

    public static String calandarwithtime(String meeting_time, String nameroom, String typesensor, String date1, String date2) {
        logger.info("j'entre dans la méthode");
        System.out.println(meeting_time + "time");

        String baseApiUrl = props.getApiLocalUrl();
        String getEquipmentUrl = baseApiUrl + "/updateAutoEquip?meeting_time=" +meeting_time +"&nameroom="+nameroom +"&typesensor="+typesensor +"&date1="+date1 +"&date2="+date2;
        //http://localhost:9000/updateAutoEquip?meeting_time=2022-01-01T02:00&nameroom=Salle de réunion&typesensor=capteur de présence&date1=2022-01-01 00:00:00&date2=2022-01-01 07:00:00
        System.out.println(getEquipmentUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                getEquipmentUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        logger.info("Get Equipment call " + response.getStatusCode().toString());
       return response.getBody();
    }

}
