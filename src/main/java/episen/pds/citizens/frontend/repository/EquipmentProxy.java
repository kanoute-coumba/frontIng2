package episen.pds.citizens.frontend.repository;
import episen.pds.citizens.frontend.CustomProperties;
import episen.pds.citizens.frontend.model.EquipmentWithConsumption;
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
        String getEquipWithConsumptionUrl = baseApiUrl + "/EquipmentOrderByConsumption/idb="+id_b;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<EquipmentWithConsumption>> response = restTemplate.exchange(
                getEquipWithConsumptionUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        logger.info("Get EquipmentWithConsumption call " + response.getStatusCode());

        return response.getBody();
    }

    public static Iterable<EquipmentWithConsumption> getEquipmentWithConsumptionByRoom(int id_r) {
        String baseApiUrl = props.getApiUrl();
        String getEquipWithConsumptionUrl = baseApiUrl + "/EquipmentOrderByConsumption/idr="+id_r;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<EquipmentWithConsumption>> response = restTemplate.exchange(
                getEquipWithConsumptionUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        logger.info("Get EquipmentWithConsumption call " + response.getStatusCode());

        return response.getBody();
    }
}
