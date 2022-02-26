package episen.pds.citizens.frontend.repository;

import episen.pds.citizens.frontend.CustomProperties;
import episen.pds.citizens.frontend.model.Consumption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.logging.Logger;

@Slf4j
@Component
public class ConsumptionProxy {

    private static final CustomProperties props = new CustomProperties();
    private static final Logger logger = Logger.getLogger(ConsumptionProxy.class.getName());

    public static Iterable<Consumption> getConsumptionByEquipment(int id_e){
        String baseApiUrl = props.getApiUrl();
        String getConsumptionByEquipmentUrl = baseApiUrl +"/ConsumptionEquipment/"+id_e;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Consumption>> response = restTemplate.exchange(
                getConsumptionByEquipmentUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        logger.info("Get Consumption By Equipment call " + response.getStatusCode());
        return response.getBody();
    }
    public static Iterable<Consumption> getConsumptionByEquipmentBetweenTwoDate(int id_e, long db, long de){
        String baseApiUrl = props.getApiUrl();
        String getConsumptionByEquipmentUrl = baseApiUrl
                +"/ConsumptionEquipment/"+id_e+"/Between/" +db+"&"+de;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Consumption>> response = restTemplate.exchange(
                getConsumptionByEquipmentUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        logger.info("Get Consumption By Equipment  Between Two Date call " + response.getStatusCode());
        return response.getBody();
    }
    public static ArrayList<Consumption> getConsumptionByRoomBetweenTwoDate(int id_r, long db, long de){
        String baseApiUrl = props.getApiUrl();
        String getConsumptionByRoomUrl = baseApiUrl
                +"/ConsumptionRoom/"+id_r+"/Between/" +db+"&"+de;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ArrayList<Consumption>> response = restTemplate.exchange(
                getConsumptionByRoomUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        logger.info("Get Consumption By Room  Between Two Date call " + response.getStatusCode());
        return response.getBody();
    }
    public static ArrayList<Consumption> getConsumptionByFloorBetweenTwoDate(int id_f, long db, long de){
        String baseApiUrl = props.getApiUrl();
        String getConsumptionByFloorUrl = baseApiUrl
                +"/ConsumptionFloor/"+id_f+"/Between/" +db+"&"+de;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ArrayList<Consumption>> response = restTemplate.exchange(
                getConsumptionByFloorUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        logger.info("Get Consumption By Floor  Between Two Date call " + response.getStatusCode());
        return response.getBody();
    }
    public static ArrayList<Consumption> getConsumptionByBuildingBetweenTwoDate(int id_f, long db, long de){
        String baseApiUrl = props.getApiUrl();
        String getConsumptionByBuildingUrl = baseApiUrl
                +"/ConsumptionBuilding/"+id_f+"/Between/" +db+"&"+de;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ArrayList<Consumption>> response = restTemplate.exchange(
                getConsumptionByBuildingUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        logger.info("Get Consumption By Building  Between Two Date call " + response.getStatusCode());
        return response.getBody();
    }
}
