package episen.pds.citizens.frontend.repository;

import episen.pds.citizens.frontend.CustomProperties;
import episen.pds.citizens.frontend.model.BuildingCentral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class BuildingCentralProxy {
    @Autowired
    private static CustomProperties props = new CustomProperties();

    public List<BuildingCentral> readBuildingsTypeCentral() {
        String url = props.getApiUrl() + "/readBuildingsTypeCentral";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<BuildingCentral>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );

        return response.getBody();
    }
}
