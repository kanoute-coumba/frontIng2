package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.model.BuildingPatch;
import episen.pds.citizens.frontend.service.BuildingServicePatch;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BuildingController {

    private BuildingServicePatch buildingServicePatch = new BuildingServicePatch();

    @GetMapping("/buildingsPatch")
    public String getBuildings(Model model) {
        Iterable<BuildingPatch> buildings = buildingServicePatch.getBuildings();
        int sumProduction = 0;
        int sumConsumption = 0;
        for(BuildingPatch building: buildings) {
            sumProduction += building.getProduction() != null ? Double.parseDouble(building.getProduction()) : 0;
            sumConsumption += building.getConsumption() != null ? Double.parseDouble(building.getConsumption()) : 0;
        }
        model.addAttribute("buildings", buildings);
        model.addAttribute("sumProduction", sumProduction);
        model.addAttribute("sumConsumption", sumConsumption);
        return "smartgrid/home.html";
    }
}
