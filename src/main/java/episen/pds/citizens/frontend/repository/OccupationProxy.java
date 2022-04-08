package episen.pds.citizens.frontend.repository;

import episen.pds.citizens.frontend.CustomProperties;
import episen.pds.citizens.frontend.model.Tenant;
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
public class OccupationProxy {

    @Autowired
    private static CustomProperties props = new CustomProperties() ;

    private static final Logger logger = Logger.getLogger(OccupationProxy.class.getName());

    public Iterable<Tenant> getTenant() {
        String baseApiUrl = props.getApiUrl();
        String getTestUrl = baseApiUrl + "/tenant";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Iterable<Tenant>> response = restTemplate.exchange(
                getTestUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Tenant>>() {
                }
        );

        logger.info("Get Tenant Call " + response.getStatusCode().toString());

        return response.getBody();
    }
}
