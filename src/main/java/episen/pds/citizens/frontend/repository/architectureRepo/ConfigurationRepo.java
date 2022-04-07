package episen.pds.citizens.frontend.repository.architectureRepo;

import episen.pds.citizens.frontend.CustomProperties;
import episen.pds.citizens.frontend.model.architectureModel.Configuration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class ConfigurationRepo {

    private RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private CustomProperties customProperties;

    // Not yet
    public Configuration getConfiguration(int id_configuration) {
        ResponseEntity<Configuration> responseEntity =
                restTemplate.exchange(customProperties.getApiArchitectureUrl() + "/configuration/" + id_configuration, HttpMethod.GET, null, Configuration.class);
        return responseEntity.getBody();
    }

    public Iterable<Configuration> getAllConfigurations() {
        ResponseEntity<Iterable<Configuration>> responseEntity =
                restTemplate.exchange(customProperties.getApiArchitectureUrl() + "/configurations", HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        return responseEntity.getBody();
    }

}
