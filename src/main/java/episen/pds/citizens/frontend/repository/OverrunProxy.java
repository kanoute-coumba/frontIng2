package episen.pds.citizens.frontend.repository;

import episen.pds.citizens.frontend.CustomProperties;
import episen.pds.citizens.frontend.model.Attribution;
import episen.pds.citizens.frontend.model.ConsoByDay;
import episen.pds.citizens.frontend.model.PeakDay;
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

    public Iterable<ConsoByDay> getConsumption() {
        String baseApiUrl = props.getApiUrl();
        String getTestUrl = baseApiUrl + "/conso";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Iterable<ConsoByDay>> response = restTemplate.exchange(
                getTestUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<ConsoByDay>>() {
                }
        );

        logger.info("Get Consobyday Call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Iterable<Attribution> getAttribution() {
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

        logger.info("Get Attribution call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Iterable<PeakDay> getPeakDay() {
        String baseApiUrl = props.getApiUrl();
        String getTestUrl = baseApiUrl + "/peak";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<PeakDay>> response = restTemplate.exchange(
                getTestUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<PeakDay>>() {
                }
        );

        logger.info("Get Attribution call " + response.getStatusCode().toString());

        return response.getBody();
    }

}
