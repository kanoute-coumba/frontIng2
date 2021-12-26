package episen.pds.citizens.frontend.repository.architectureRepo;

import episen.pds.citizens.frontend.CustomProperties;
import episen.pds.citizens.frontend.model.architectureModel.Building;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class BuildingRepo {

    private RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private CustomProperties customProperties;

    public Building getBuilding(int id_building) {
        ResponseEntity<Building> responseEntity =
                restTemplate.exchange(customProperties.getApiArchitectureUrl() + "/building/" + id_building, HttpMethod.GET, null, Building.class);
        return responseEntity.getBody();
    }

    public Iterable<Building> getAllBuildings() {
        ResponseEntity<Iterable<Building>> responseEntity =
                restTemplate.exchange(customProperties.getApiArchitectureUrl() + "/buildings", HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        return responseEntity.getBody();
    }

}

