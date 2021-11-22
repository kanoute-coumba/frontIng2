package episen.pds.citizens.frontend.repository;

import episen.pds.citizens.frontend.CustomProperties;
import episen.pds.citizens.frontend.model.MixEn;
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
public class MixEnProxy {

    @Autowired
    private static CustomProperties props = new CustomProperties();
    private static final Logger logger = Logger.getLogger(MixEnProxy.class.getName());

    public static Iterable<MixEn> getCurrentMixEn() {
        String baseApiUrl = props.getApiUrl();
        String getTestUrl = baseApiUrl + "/Mix";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<MixEn>> response = restTemplate.exchange(
                getTestUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<MixEn>>() {
                }
        );

        //log.debug("Get Test call " + response.getStatusCode().toString());

        return response.getBody();


    }
}
