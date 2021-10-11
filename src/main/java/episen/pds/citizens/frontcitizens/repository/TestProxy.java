package episen.pds.citizens.frontcitizens.repository;

import episen.pds.citizens.frontcitizens.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TestProxy {

    @Autowired
    private CustomProperties props;

    public Iterable<Test> getTests() {
        String baseApiUrl = props.getApiUrl();
        String getTestUrl = baseApiUrl + "/posts";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Test>> response = restTemplate.exchange(
                getTestUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Test>>() {}
        );

        log.debug("Get Test call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Test createTest(Test e) {
        String baseApiUrl = props.getApiUrl();
        String createTestUrl = baseApiUrl + "/createTest";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Test> request = new HttpEntity<Test>(e);
        ResponseEntity<Test> response = restTemplate.exchange(
                createTestUrl,
                HttpMethod.POST,
                request,
                Test.class);

        log.debug("Create Test call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Test updateTest(Test e) {
        String baseApiUrl = props.getApiUrl();
        String updateTestUrl = baseApiUrl + "/updateTest";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Test> request = new HttpEntity<Test>(e);
        ResponseEntity<Test> response = restTemplate.exchange(
                updateTestUrl,
                HttpMethod.POST,
                request,
                Test.class);

        log.debug("Update Test call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Test getTest() {
        String baseApiUrl = props.getApiUrl();
        String createTestUrl = baseApiUrl + "/posts/1";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Test> response = restTemplate.exchange(
                createTestUrl,
                HttpMethod.GET,
                null,
                Test.class);

        log.debug("Get Test call " + response.getStatusCode().toString());

        return response.getBody();
    }
    
}