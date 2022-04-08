package episen.pds.citizens.frontend.repository;

import episen.pds.citizens.frontend.CustomProperties;
import episen.pds.citizens.frontend.model.Messages;
import episen.pds.citizens.frontend.model.Reservation;
import episen.pds.citizens.frontend.model.Users;
import episen.pds.citizens.frontend.model.architectureModel.Space;
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
public class ReservationProxy {

    @Autowired
    private static CustomProperties props = new CustomProperties();
    private static final Logger logger = Logger.getLogger(ReservationProxy.class.getName());

    public static Reservation getReservationById(int id) {
        String baseApiUrl = props.getApiUrl();
        String getTestUrl = baseApiUrl + "/reservations/" + id;
        log.info(getTestUrl);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Reservation> response = restTemplate.exchange(
                getTestUrl,
                HttpMethod.GET,
                null,
                Reservation.class);
        log.info(getTestUrl);

        log.debug("Get Test call " + response.getStatusCode().toString());
        return response.getBody();
    }


    public static Iterable<Reservation> getReservation() {
        String baseApiUrl = props.getApiUrl();
        String getTestUrl = baseApiUrl + "/reservations";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Reservation>> response = restTemplate.exchange(
                getTestUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Reservation>>() {
                }
        );

        logger.info("Get Test call " + response.getStatusCode().toString());

        return response.getBody();


    }

    public static Iterable<Space> getReservedSpace() {
        String baseApiUrl = props.getApiUrl();
        String getTestUrl = baseApiUrl + "/spaces";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Space>> response = restTemplate.exchange(
                getTestUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Space>>() {
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
