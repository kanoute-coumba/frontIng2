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

    public static Iterable<String> getEquipment(String variable1, String variable2) {
        String baseApiUrl = props.getApiUrl();
        String getEquipmentUrl = baseApiUrl + "/ListEquipment?typEquipement="+ variable1 +"&location="+variable2;

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

}
