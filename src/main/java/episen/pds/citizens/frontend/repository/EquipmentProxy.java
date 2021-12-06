package episen.pds.citizens.frontend.repository;
import episen.pds.citizens.frontend.CustomProperties;
import episen.pds.citizens.frontend.model.EquipmentWithConsumption;
import episen.pds.citizens.frontend.service.TestService;
import lombok.extern.slf4j.Slf4j;
import episen.pds.citizens.frontend.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Slf4j
@Component
public class EquipmentProxy {
    @Autowired
    private static CustomProperties props = new CustomProperties();
    private static final Logger logger = Logger.getLogger(EquipmentProxy.class.getName());

    public static Iterable<EquipmentWithConsumption> getEquipmentWithConsumption(int id_b) {
        String baseApiUrl = props.getApiUrl();
        String getEquipWithConsumptionUrl = baseApiUrl + "/EquipmentByConsumption/"+id_b;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<EquipmentWithConsumption>> response = restTemplate.exchange(
                getEquipWithConsumptionUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<EquipmentWithConsumption>>() {
                }
        );

        logger.info("Get EquipmentWithConsumption call " + response.getStatusCode().toString());

        return response.getBody();
    }

}
