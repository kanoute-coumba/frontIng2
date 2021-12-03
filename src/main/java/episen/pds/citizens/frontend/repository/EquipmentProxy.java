package episen.pds.citizens.frontend.repository;

import episen.pds.citizens.frontend.CustomProperties;
import episen.pds.citizens.frontend.model.Equipment;
import episen.pds.citizens.frontend.model.Test;
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
    private static CustomProperties props = new CustomProperties();
    private static final Logger logger = Logger.getLogger(EquipmentProxy.class.getName());

    public static Iterable<String> getEquipment(Integer variable1, Integer variable2) {
        String baseApiUrl = props.getApiUrl();
        String getEquipmentUrl = baseApiUrl + "/ListEquipment?id_room=" + variable1 + "&id_floor=" + variable2;

        System.out.println(getEquipmentUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<String>> response = restTemplate.exchange(
                getEquipmentUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<String>>() {
                }
        );

        log.debug("Get Equipment call " + response.getStatusCode().toString());

        return response.getBody();


    }

    public static String getLampe(Integer id_room, Integer id_equipment) {
        String baseApiUrl = props.getApiUrl();
        String getEquipmentUrl = baseApiUrl + "/Lampe?id_room=" + id_room + "&id_equipment=" + id_equipment;

        System.out.println(getEquipmentUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                getEquipmentUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<String>() {
                }
        );

        log.debug("Get Equipment call " + response.getStatusCode().toString());

        return response.getBody();

    }

    public static String getClimatisation(Integer id_room, Integer id_equipment) {
        String baseApiUrl = props.getApiUrl();
        String getEquipmentUrl = baseApiUrl + "/Climatisation?id_room=" + id_room + "&id_equipment=" + id_equipment;

        System.out.println(getEquipmentUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                getEquipmentUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<String>() {
                }
        );

        log.debug("Get Equipment call " + response.getStatusCode().toString());

        return response.getBody();

    }

    public static String getRadiateur(Integer id_room, Integer id_equipment) {
        String baseApiUrl = props.getApiUrl();
        String getEquipmentUrl = baseApiUrl + "/Radiateur?id_room=" + id_room + "&id_equipment=" + id_equipment;

        System.out.println(getEquipmentUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                getEquipmentUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<String>() {
                }
        );

        log.debug("Get Equipment call " + response.getStatusCode().toString());

        return response.getBody();

    }

    public static String getFenetre(Integer id_room, Integer id_equipment) {
        String baseApiUrl = props.getApiUrl();
        String getEquipmentUrl = baseApiUrl + "/Fenetre?id_room=" + id_room + "&id_equipment=" + id_equipment;

        System.out.println(getEquipmentUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                getEquipmentUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<String>() {
                }
        );

        log.debug("Get Equipment call " + response.getStatusCode().toString());

        return response.getBody();

    }

    public static String getStore(Integer id_room, Integer id_equipment) {
        String baseApiUrl = props.getApiUrl();
        String getEquipmentUrl = baseApiUrl + "/Store?id_room=" + id_room + "&id_equipment=" + id_equipment;

        System.out.println(getEquipmentUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                getEquipmentUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<String>() {
                }
        );

        log.debug("Get Equipment call " + response.getStatusCode().toString());

        return response.getBody();

    }

    public static String getScreen(Integer id_room, Integer id_equipment) {
        String baseApiUrl = props.getApiUrl();
        String getEquipmentUrl = baseApiUrl + "/Screen?id_room=" + id_room + "&id_equipment=" + id_equipment;

        System.out.println(getEquipmentUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                getEquipmentUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<String>() {
                }
        );

        log.debug("Get Equipment call " + response.getStatusCode().toString());

        return response.getBody();

    }
}
