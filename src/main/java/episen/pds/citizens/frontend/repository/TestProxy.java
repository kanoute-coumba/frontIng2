package episen.pds.citizens.frontend.repository;

import episen.pds.citizens.frontend.CustomProperties;
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
public class TestProxy {

    @Autowired
    private static CustomProperties props = new CustomProperties();
    private static final Logger logger = Logger.getLogger(TestProxy.class.getName());

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

        logger.info("Get Test call " + response.getStatusCode().toString());

        return response.getBody();


    }

    public Test createTest(Test e) {
        String baseApiUrl = props.getApiUrl();
        String createTestUrl = baseApiUrl + "/Form";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Test> request = new HttpEntity(e);
        ResponseEntity<Test> response = restTemplate.exchange(
                createTestUrl,
                HttpMethod.POST,
                request,
                Test.class);
        System.out.println(request);

        logger.info("Create Test call " + response.getStatusCode().toString());

        return response.getBody();
    }


    public Test updateTest(Test test) {
        return null;
    }

    public void deleteTestId(int id) {
        String baseApiUrl = props.getApiUrl();
        String deleteTestUrl = baseApiUrl + "/DeleteId/"+id;

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Test> response = restTemplate.exchange(
                deleteTestUrl,
                HttpMethod.POST,
                null,
                Test.class);
        response.getBody();
    }


}
