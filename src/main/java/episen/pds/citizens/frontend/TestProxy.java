package episen.pds.citizens.frontend;

import lombok.extern.slf4j.Slf4j;
import model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class TestProxy {

    @Autowired
    private CustomProperties props;

    public Iterable<Test> getTest() {
        String baseApiUrl = props.getApiUrl();
        String getTestUrl = baseApiUrl + "/Test";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Test>> response = restTemplate.exchange(
                getTestUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Test>>() {}
        );

        log.debug("Get Employees call " + response.getStatusCode().toString());

        return response.getBody();


    }
}
