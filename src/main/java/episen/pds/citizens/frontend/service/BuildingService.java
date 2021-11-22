package episen.pds.citizens.frontend.service;

import episen.pds.citizens.frontend.model.Building;
import episen.pds.citizens.frontend.repository.BuildingProxy;
import org.springframework.beans.factory.annotation.Autowired;


public class BuildingService {

    @Autowired
    private BuildingProxy buildingProxy = new BuildingProxy();

    public Iterable<Building> getBuildings() {
        return buildingProxy.getBuildings();
    }
}