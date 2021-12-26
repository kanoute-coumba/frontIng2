package episen.pds.citizens.frontend.service.architectureService;

import episen.pds.citizens.frontend.model.architectureModel.Building;
import episen.pds.citizens.frontend.repository.architectureRepo.BuildingRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class BuildingService {
    @Autowired
    private BuildingRepo buildingRepo;

    public Building getBuilding(final int id_building) {
        return buildingRepo.getBuilding(id_building);
    }

    public Iterable<Building> getAllBuildings() {
        return buildingRepo.getAllBuildings();
    }


}

