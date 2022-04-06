package episen.pds.citizens.frontend.repository;

import episen.pds.citizens.frontend.CustomProperties;
import episen.pds.citizens.frontend.model.Consumption;
import episen.pds.citizens.frontend.model.architectureModel.Floor;
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
public class FloorProxy {

    private static final CustomProperties props = new CustomProperties();
    private static final Logger logger = Logger.getLogger(ConsumptionProxy.class.getName());

    public static ArrayList<Floor> getFloorByIdBuilding(int idb){
        String baseApiUrl = props.getApiUrl();
        String getConsumptionByEquipmentUrl = baseApiUrl +"/FloorByIdBuilding/"+idb;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ArrayList<Floor>> response = restTemplate.exchange(
                getConsumptionByEquipmentUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        logger.info("Get Floor By Building call " + response.getStatusCode());
        return response.getBody();
    }
}
