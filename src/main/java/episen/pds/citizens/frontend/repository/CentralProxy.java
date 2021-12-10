package episen.pds.citizens.frontend.repository;

import episen.pds.citizens.frontend.CustomProperties;
import episen.pds.citizens.frontend.model.CentralByProduction;
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
public class CentralProxy {
    @Autowired
    private static final CustomProperties props = new CustomProperties();
    private static final Logger logger = Logger.getLogger(CentralProxy.class.getName());

    public static Iterable<CentralByProduction> getCentralByProduction(int id_b) {
        String baseApiUrl = props.getApiUrl();
        String getCentralByProductionUrl = baseApiUrl + "/CentralByProduction/"+id_b;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<CentralByProduction>> response = restTemplate.exchange(
                getCentralByProductionUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        logger.info("Get CentralByProduction call " + response.getStatusCode());

        return response.getBody();
    }
}
