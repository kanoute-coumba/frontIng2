package episen.pds.citizens.frontend.service.architectureService;

import episen.pds.citizens.frontend.model.architectureModel.Floor;
import episen.pds.citizens.frontend.repository.FloorProxy;
import episen.pds.citizens.frontend.repository.architectureRepo.FloorRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Data
@Service
public class FloorService {
    @Autowired
    private FloorRepo floorRepo;

    private FloorProxy floorProxy = new FloorProxy();

    public Iterable<Floor> getFloorsOfBuilding(final String name_building) {
        return floorRepo.getFloorsOfBuilding(name_building);
    }
    public ArrayList<Floor> getFloorByIdBuilding(int idb){
        return floorProxy.getFloorByIdBuilding(idb);
    }
    // Not yet
    public Floor getFloor(final int id_floor) {
        return floorRepo.getFloor(id_floor);
    }

    public String getDesignOfFloor(final String name_floor) {
        return floorRepo.getDesignOfFloor(name_floor);
    }


}

