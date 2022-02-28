package episen.pds.citizens.frontend.service.architectureService;

import episen.pds.citizens.frontend.model.architectureModel.Space;
import episen.pds.citizens.frontend.repository.architectureRepo.SpaceRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Data
@Service
public class SpaceService {
    @Autowired
    private SpaceRepo spaceRepo;

    // Not yet
    public Iterable<Space> getSpacesOfBuilding(final String name_building) {
        return spaceRepo.getSpacesOfBuilding(name_building);
    }

    public Iterable<Space> getSpacesOfFloor(final String name_floor) {
        return spaceRepo.getSpacesOfFloor(name_floor);
    }

    public Iterable<Space> getSpacesOfFloorByType(final String name_floor, final String type_space) {
        return spaceRepo.getSpacesOfFloorByType(name_floor,type_space);
    }

    // Not yet
    public Space getSpace(final int id_space) {
        return spaceRepo.getSpace(id_space);
    }

}

