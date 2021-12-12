package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.model.Building;
import episen.pds.citizens.frontend.service.BuildingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BuildingController {

    private BuildingService buildingService = new BuildingService();

    @GetMapping("/buildings")
    public String getBuildings(Model model) {
        Iterable<Building> buildings = buildingService.getBuildings();
        model.addAttribute("buildings", buildings);
        return "smartgrid/home.html";
    }
}
