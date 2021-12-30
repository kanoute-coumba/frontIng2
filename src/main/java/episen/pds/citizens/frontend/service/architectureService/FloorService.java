package episen.pds.citizens.frontend.service.architectureService;

import episen.pds.citizens.frontend.model.architectureModel.Floor;
import episen.pds.citizens.frontend.repository.architectureRepo.FloorRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class FloorService {
    @Autowired
    private FloorRepo floorRepo;

    public Iterable<Floor> getFloorsOfBuilding(final String name_building) {
        return floorRepo.getFloorsOfBuilding(name_building);
    }

    // Not yet
    public Floor getFloor(final int id_floor) {
        return floorRepo.getFloor(id_floor);
    }

    public String getDesignOfFloor(final String name_floor) {
        return floorRepo.getDesignOfFloor(name_floor);
    }


}

