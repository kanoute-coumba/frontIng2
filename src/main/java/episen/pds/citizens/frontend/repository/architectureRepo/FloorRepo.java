package episen.pds.citizens.frontend.repository.architectureRepo;

import episen.pds.citizens.frontend.CustomProperties;
import episen.pds.citizens.frontend.model.architectureModel.Floor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class FloorRepo {

    private RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private CustomProperties customProperties;

    public Floor getFloor(int id_floor) {
        ResponseEntity<Floor> responseEntity =
                restTemplate.exchange(customProperties.getApiArchitectureUrl() + "/floor/" + id_floor, HttpMethod.GET, null, Floor.class);
        return responseEntity.getBody();
    }

    public String getDesignOfFloor(String name_floor) {
        ResponseEntity<String> responseEntity =
                restTemplate.exchange(customProperties.getApiArchitectureUrl() + "/design_of/" + name_floor, HttpMethod.GET, null, new ParameterizedTypeReference<String>() {});
        return responseEntity.getBody();
    }

    public Iterable<Floor> getFloorsOfBuilding(String name_building) {
        ResponseEntity<Iterable<Floor>> responseEntity =
                restTemplate.exchange(customProperties.getApiArchitectureUrl() + "/floors_of/" + name_building, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        return responseEntity.getBody();
    }

    public Iterable<Floor> getAllFloors() {
        ResponseEntity<Iterable<Floor>> responseEntity =
                restTemplate.exchange(customProperties.getApiArchitectureUrl() + "/floors", HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        return responseEntity.getBody();
    }


}
