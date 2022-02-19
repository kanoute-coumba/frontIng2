package episen.pds.citizens.frontend.repository;

import episen.pds.citizens.frontend.CustomProperties;
import episen.pds.citizens.frontend.model.Consumption;
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
public class ConsumptionProxy {
    @Autowired
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
}
