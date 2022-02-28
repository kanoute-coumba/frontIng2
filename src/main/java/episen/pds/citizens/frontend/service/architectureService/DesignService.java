package episen.pds.citizens.frontend.service.architectureService;

import episen.pds.citizens.frontend.model.architectureModel.Design;
import episen.pds.citizens.frontend.repository.architectureRepo.DesignRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class DesignService {
    @Autowired
    private DesignRepo designRepo;

    // Not yet
    public Iterable<Design> getAllDesigns() {
        return designRepo.getAllDesigns();
    }

    // Not yet
    public Design getDesign(final int id_design) {
        return designRepo.getDesign(id_design);
    }

    // Not yet
    public Design getDesignByName(final String name_design) {
        return designRepo.getDesignByName(name_design);
    }

}

