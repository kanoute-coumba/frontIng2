package episen.pds.citizens.frontend.repository;

import episen.pds.citizens.frontend.CustomProperties;
import episen.pds.citizens.frontend.model.Messages;
import episen.pds.citizens.frontend.model.Messages;
import episen.pds.citizens.frontend.model.Test;
import episen.pds.citizens.frontend.model.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Slf4j
@Component
public class MessagesProxy {

    @Autowired
    private static CustomProperties props = new CustomProperties();
    private static final Logger logger = Logger.getLogger(MessagesProxy.class.getName());

    public static Messages getMessagesById(int id) {
        String baseApiUrl = props.getApiUrl();
        String getTestUrl = baseApiUrl + "/messages/" + id;
        log.info(getTestUrl);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Messages> response = restTemplate.exchange(
                getTestUrl,
                HttpMethod.GET,
                null,
                Messages.class);
        log.info(getTestUrl);

        log.debug("Get Test call " + response.getStatusCode().toString());
        return response.getBody();
    }

    public static Iterable<Messages> getMessageBySenderAndReceiver(String sender, String receiver) {
        String baseApiUrl = props.getApiUrl();
        String getTestUrl = baseApiUrl + "/messages/sender=" + sender + "/receiver=" + receiver;

        RestTemplate restTemplate = new RestTemplate();
        log.info(getTestUrl);

        ResponseEntity<Iterable<Messages>> response = restTemplate.exchange(
                getTestUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Messages>>() {
                }
                );

        logger.info("Get Test call " + response.getStatusCode().toString());

        return response.getBody();

    }


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
