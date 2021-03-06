package episen.pds.citizens.frontend.repository;

import episen.pds.citizens.frontend.CustomProperties;
import episen.pds.citizens.frontend.model.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.logging.Logger;

@Slf4j
@Component
public class UsersProxy {

    @Autowired
    private static CustomProperties props = new CustomProperties();
    private static final Logger logger = Logger.getLogger(UsersProxy.class.getName());



    public static Iterable<Users> getUsers() {
        String baseApiUrl = props.getApiUrl();
        String getTestUrl = baseApiUrl + "/users";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Users>> response = restTemplate.exchange(
                getTestUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Users>>() {
                }
        );

        logger.info("Get Test call " + response.getStatusCode().toString());

        return response.getBody();
    }
    public static ArrayList<Users> getUsersByUserName(String uName) {
        logger.info("proxy getUsersByUserName");
        String baseApiUrl = props.getApiUrl();
        String getUrl = baseApiUrl + "/usersName="+uName;
        logger.info(getUrl);
        RestTemplate restTemplate = new RestTemplate();
        logger.info("avant ResponseEntity");
        ResponseEntity<ArrayList<Users>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        logger.info("avant le retour du proxy");
        return response.getBody();
    }
    public static Users getUsersByUserId(int id) {
        logger.info("proxy getUsersByUserId");
        String baseApiUrl = props.getApiUrl();
        String getUrl = baseApiUrl + "/users/"+id;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Users> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        return response.getBody();
    }

  /*  public Messages_reservation reserveMessages (Messages_reservation Messages_reservation) {
        String baseApiUrl = props.getApiUrl();
        String createTestUrl = baseApiUrl + "/cafeteria_reservation";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Messages_reservation> request = new HttpEntity(Messages_reservation);
        ResponseEntity<Messages_reservation> response = restTemplate.exchange(
                createTestUrl,
                HttpMethod.POST,
                request,
                Messages_reservation.class);
        System.out.println(request);

        log.debug("Create Test call " + response.getStatusCode().toString());

        return response.getBody();
    }*/

}
