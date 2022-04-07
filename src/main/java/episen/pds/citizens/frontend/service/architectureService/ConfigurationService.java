package episen.pds.citizens.frontend.service.architectureService;

import episen.pds.citizens.frontend.model.architectureModel.Configuration;
import episen.pds.citizens.frontend.repository.architectureRepo.ConfigurationRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class ConfigurationService {
    @Autowired
    private ConfigurationRepo configurationRepo;

    // Not yet
    public Configuration getConfiguration(final int id_configuration) {
        return configurationRepo.getConfiguration(id_configuration);
    }

    public Iterable<Configuration> getAllConfigurations() {
        return configurationRepo.getAllConfigurations();
    }


}

