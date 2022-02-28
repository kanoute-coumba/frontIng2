package episen.pds.citizens.frontend.repository.architectureRepo;

import episen.pds.citizens.frontend.CustomProperties;
import episen.pds.citizens.frontend.model.architectureModel.Building;
import episen.pds.citizens.frontend.model.architectureModel.Design;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Component
public class DesignRepo {

    private RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private CustomProperties customProperties;

    // Not yet
    public Iterable<Design> getAllDesigns() {
        ResponseEntity<Iterable<Design>> responseEntity =
                restTemplate.exchange(customProperties.getApiArchitectureUrl() + "/designs", HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        return responseEntity.getBody();
    }

    // Not yet
    public Design getDesign(int id_design) {
        ResponseEntity<Design> responseEntity =
                restTemplate.exchange(customProperties.getApiArchitectureUrl() + "/design/" + id_design, HttpMethod.GET, null, Design.class);
        return responseEntity.getBody();
    }

    // Not yet
    public Design getDesignByName(String name_design) {
        ResponseEntity<Design> responseEntity =
                restTemplate.exchange(customProperties.getApiArchitectureUrl() + "/design_by_name/" + name_design, HttpMethod.GET, null, Design.class);
        return responseEntity.getBody();
    }

}
