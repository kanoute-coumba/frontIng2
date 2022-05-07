package episen.pds.citizens.frontend.repository;

import episen.pds.citizens.frontend.CustomProperties;
import episen.pds.citizens.frontend.model.Consumption;
import episen.pds.citizens.frontend.model.Production;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Slf4j
@Component
public class ProductionProxy {
    private static final CustomProperties props = new CustomProperties();
    private static final Logger logger = Logger.getLogger(ProductionProxy.class.getName());

    public static Production getProductionByIdBuilding(int idb){
        String baseApiUrl = props.getApiUrl();
        String getConsumptionByEquipmentUrl = baseApiUrl +"/currentProductionByIdBuilding/"+idb;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Production> response = restTemplate.exchange(
                getConsumptionByEquipmentUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        logger.info("Get getProductionByIdBuilding " + response.getStatusCode());
        return response.getBody();
    }
}
