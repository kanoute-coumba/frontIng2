package episen.pds.citizens.frontend.repository;

import episen.pds.citizens.frontend.CustomProperties;
import episen.pds.citizens.frontend.model.Menu;
import episen.pds.citizens.frontend.model.Menu_reservation;
import episen.pds.citizens.frontend.model.Test;
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
public class MenuProxy {

    @Autowired
    private static CustomProperties props = new CustomProperties();
    private static final Logger logger = Logger.getLogger(MenuProxy.class.getName());

    public static Menu getMenuById(int id) {
        String baseApiUrl = props.getApiUrl();
        String getTestUrl = baseApiUrl + "/cafeteria/" + id;

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Menu> response = restTemplate.exchange(
                getTestUrl,
                HttpMethod.GET,
                null,
                Menu.class);

        log.debug("Get Test call " + response.getStatusCode().toString());
        return response.getBody();
    }

    public static Menu_reservation getMenuReservation(int id) {
        String baseApiUrl = props.getApiUrl();
        String getTestUrl = baseApiUrl + "/cafeteria_reservation";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Menu_reservation> response = restTemplate.exchange(
                getTestUrl,
                HttpMethod.GET,
                null,
                Menu_reservation.class);

        log.debug("Get Test call " + response.getStatusCode().toString());
        return response.getBody();
    }

    public Menu_reservation reserveMenu (Menu_reservation menu_reservation) {
        String baseApiUrl = props.getApiUrl();
        String createTestUrl = baseApiUrl + "/cafeteria_reservation";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Menu_reservation> request = new HttpEntity(menu_reservation);
        ResponseEntity<Menu_reservation> response = restTemplate.exchange(
                createTestUrl,
                HttpMethod.POST,
                request,
                Menu_reservation.class);
        System.out.println(request);

        log.debug("Create Test call " + response.getStatusCode().toString());

        return response.getBody();
    }

}
