package episen.pds.citizens.frontend.service;

import episen.pds.citizens.frontend.model.BuildingCentral;
import episen.pds.citizens.frontend.repository.BuildingCentralProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingCentralService {

    @Autowired
    private BuildingCentralProxy buildingCentralProxy;

    public List<BuildingCentral> readBuildingsTypeCentral() {
        return buildingCentralProxy.readBuildingsTypeCentral();
    }
}
