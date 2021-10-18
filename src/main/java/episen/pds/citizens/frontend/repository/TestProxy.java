package episen.pds.citizens.frontend.repository;

import episen.pds.citizens.frontend.CustomProperties;
import lombok.extern.slf4j.Slf4j;
import episen.pds.citizens.frontend.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class TestProxy {

    @Autowired
    private static CustomProperties props = new CustomProperties();

    public static Iterable<Test> getTest() {
        String baseApiUrl = props.getApiUrl();
        String getTestUrl = baseApiUrl + "/Test";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Test>> response = restTemplate.exchange(
                getTestUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Test>>() {
                }
        );

        log.debug("Get Test call " + response.getStatusCode().toString());

        return response.getBody();


    }

    public Test createTest(Test e) {
        String baseApiUrl = props.getApiUrl();
        String createTestUrl = baseApiUrl + "/Form";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Test> request = new HttpEntity<Test>(e);
        ResponseEntity<Test> response = restTemplate.exchange(
                createTestUrl,
                HttpMethod.POST,
                request,
                Test.class);
        System.out.println(request);

        log.debug("Create Test call " + response.getStatusCode().toString());

        return response.getBody();
    }



    public Test updateTest(Test test) {
        return null;
    }

    public void deleteTest(int id) {
    }


}
