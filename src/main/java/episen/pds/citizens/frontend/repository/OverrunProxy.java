package episen.pds.citizens.frontend.repository;

import episen.pds.citizens.frontend.CustomProperties;
import episen.pds.citizens.frontend.model.Attribution;
import episen.pds.citizens.frontend.model.Consobyday;
import episen.pds.citizens.frontend.model.Consumption;
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
public class OverrunProxy {
    @Autowired
    private static CustomProperties props = new CustomProperties();
    private static final Logger logger = Logger.getLogger(OverrunProxy.class.getName());

    public static Iterable<Consobyday> getConsumption() {
        String baseApiUrl = props.getApiUrl();
        String getTestUrl = baseApiUrl + "/conso";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Consobyday>> response = restTemplate.exchange(
                getTestUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Consobyday>>() {
                }
        );

        log.debug("Get Consumption call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public static Iterable<Attribution> getAttribution() {
        String baseApiUrl = props.getApiUrl();
        String getTestUrl = baseApiUrl + "/overrun";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Attribution>> response = restTemplate.exchange(
                getTestUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Attribution>>() {
                }
        );

        log.debug("Get Attribution call " + response.getStatusCode().toString());

        return response.getBody();
    }
}
