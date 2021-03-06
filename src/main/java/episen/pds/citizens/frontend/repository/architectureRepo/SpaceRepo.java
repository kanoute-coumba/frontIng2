package episen.pds.citizens.frontend.repository.architectureRepo;

import episen.pds.citizens.frontend.CustomProperties;
import episen.pds.citizens.frontend.model.architectureModel.Space;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Slf4j
@Component
public class SpaceRepo {

    private RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private CustomProperties customProperties;

    public Space getSpaceByName(String name_space) {
        ResponseEntity<Space> responseEntity =
                restTemplate.exchange(customProperties.getApiArchitectureUrl() + "/spaces/" + name_space, HttpMethod.GET, null, Space.class);
        return responseEntity.getBody();
    }

    public Iterable<Space> getSpacesOfFloor(String name_floor) {
        ResponseEntity<Iterable<Space>> responseEntity =
                restTemplate.exchange(customProperties.getApiArchitectureUrl() + "/spaces_of_floor/" + name_floor, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        return responseEntity.getBody();
    }

    public Iterable<Space> getSpacesOfFloorByType(String name_floor, String type_space) {
        ResponseEntity<Iterable<Space>> responseEntity =
                restTemplate.exchange(customProperties.getApiArchitectureUrl() + "/spaces_of_floor_by_type/" + name_floor + "/" + type_space, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        return responseEntity.getBody();
    }

}

