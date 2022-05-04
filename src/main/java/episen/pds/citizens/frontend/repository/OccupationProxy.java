package episen.pds.citizens.frontend.repository;

import episen.pds.citizens.frontend.CustomProperties;
import episen.pds.citizens.frontend.model.*;
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
public class OccupationProxy {

    @Autowired
    private static CustomProperties props = new CustomProperties();

    private static final Logger logger = Logger.getLogger(OccupationProxy.class.getName());

    public Iterable<Tenant> getTenant() {
        String baseApiUrl = props.getApiLocalUrl();
        String getTestUrl = baseApiUrl + "/tenant";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Iterable<Tenant>> response = restTemplate.exchange(
                getTestUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Tenant>>() {
                }
        );

        logger.info("Get Tenant Call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Iterable<DWPbyBuilding> getDWPbuildings() {
        String baseApiUrl = props.getApiLocalUrl();
        String getTestUrl = baseApiUrl + "/dwp_buildings";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Iterable<DWPbyBuilding>> response = restTemplate.exchange(
                getTestUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<DWPbyBuilding>>() {
                }
        );

        logger.info("Get DWPbyBuilding Call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Iterable<TenantDetails> getTenantDetails() {
        String baseApiUrl = props.getApiLocalUrl();
        String getTestUrl = baseApiUrl + "/tenantdetails";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Iterable<TenantDetails>> response = restTemplate.exchange(
                getTestUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<TenantDetails>>() {
                }
        );

        logger.info("Get TenantDetails Call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Iterable<RentCounterByYear> getCounterByYear() {
        String baseApiUrl = props.getApiLocalUrl();
        String getTestUrl = baseApiUrl + "/rentyearcounter";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Iterable<RentCounterByYear>> response = restTemplate.exchange(
                getTestUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<RentCounterByYear>>() {
                }
        );

        logger.info("Get RentCounterByYear Call " + response.getStatusCode().toString());

        return response.getBody();
    }



    public Iterable<OccupationRate> getOccupationRate() {
        String baseApiUrl = props.getApiLocalUrl();
        String getTestUrl = baseApiUrl + "/occupation_rate";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Iterable<OccupationRate>> response = restTemplate.exchange(
                getTestUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<OccupationRate>>() {
                }
        );

        logger.info("Get OccupationRate Call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Iterable<OccupationRateByBuilding> get2020Rate() {
        String baseApiUrl = props.getApiLocalUrl();
        String getTestUrl = baseApiUrl + "/2020rate";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Iterable<OccupationRateByBuilding>> response = restTemplate.exchange(
                getTestUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<OccupationRateByBuilding>>() {
                }
        );

        logger.info("Get OccupationRateByBuilding Call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Iterable<OccupationRateByBuilding> get2021Rate() {
        String baseApiUrl = props.getApiLocalUrl();
        String getTestUrl = baseApiUrl + "/2021rate";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Iterable<OccupationRateByBuilding>> response = restTemplate.exchange(
                getTestUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<OccupationRateByBuilding>>() {
                }
        );

        logger.info("Get OccupationRateByBuilding Call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Iterable<OccupationRateByBuilding> get2022Rate() {
        String baseApiUrl = props.getApiLocalUrl();
        String getTestUrl = baseApiUrl + "/2022rate";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Iterable<OccupationRateByBuilding>> response = restTemplate.exchange(
                getTestUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<OccupationRateByBuilding>>() {
                }
        );

        logger.info("Get OccupationRateByBuilding Call " + response.getStatusCode().toString());

        return response.getBody();
    }
}
