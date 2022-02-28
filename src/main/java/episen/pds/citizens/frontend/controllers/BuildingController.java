package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.model.BuildingPatch;
import episen.pds.citizens.frontend.service.BuildingServicePatch;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class BuildingController {

    private BuildingServicePatch buildingServicePatch = new BuildingServicePatch();

    @GetMapping("/buildingsPatch")
    public String getBuildings(Model model) {
        Iterable<BuildingPatch> buildings = buildingServicePatch.getBuildings();
        int sumProduction = 0;
        int sumConsumption = 0;
        for(BuildingPatch building: buildings) {
            sumProduction += building.getProduction() != null ? building.getProduction() : 0;
            sumConsumption += building.getConsumption() != null ? building.getConsumption() : 0;
        }

        Map<Integer, Double> productionByDistrict = new HashMap<>();
        Map<Integer, Double> consumptionByDistrict = new HashMap<>();
        for(BuildingPatch building: buildings) {
            if(!productionByDistrict.keySet().contains(building.getDistrict())) {
                productionByDistrict.put(building.getDistrict(), building.getProduction());
                consumptionByDistrict.put(building.getDistrict(), building.getConsumption());

            } else {
                productionByDistrict.put(building.getDistrict(), productionByDistrict.get(building.getDistrict()) + building.getProduction());
                consumptionByDistrict.put(building.getDistrict(), consumptionByDistrict.get(building.getDistrict()) + building.getConsumption());
            }
        }

        model.addAttribute("productionByDistrict", productionByDistrict);
        model.addAttribute("consumptionByDistrict", consumptionByDistrict);
        model.addAttribute("buildings", buildings);
        model.addAttribute("sumProduction", sumProduction);
        model.addAttribute("sumConsumption", sumConsumption);
        return "smartgrid/home.html";
    }
}
