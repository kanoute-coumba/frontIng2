package episen.pds.citizens.frontend.service;

import episen.pds.citizens.frontend.model.BuildingPatch;
import episen.pds.citizens.frontend.repository.BuildingProxy;
import org.springframework.beans.factory.annotation.Autowired;


public class BuildingServicePatch {

    @Autowired
    private BuildingProxy buildingProxy = new BuildingProxy();

    public Iterable<BuildingPatch> getBuildings() {
        return buildingProxy.getBuildings();
    }
}