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
        model.addAttribute("buildings", buildings);
        return "smartgrid/home.html";
    }
}
