package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.service.architectureService.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArchitectureController {

    @Autowired
    private BuildingService buildingService;

    @GetMapping("/accessMap")
    public String getAccessMap(Model model) {
        model.addAttribute("buildings", buildingService.getBuildings());
        return "architectureTemplates/accessTemplates/access-map";
    }

    @GetMapping("/accessMap/display")
    public String getDisplayAccessMap(Model model) {
        return "architectureTemplates/accessTemplates/display-access-map";
    }

    @GetMapping("/guidanceOption")
    public String getGuidanceOption(Model model) {
        return "architectureTemplates/guidanceTemplates/guidance-option";
    }

    @GetMapping("/guidanceOption/display")
    public String getDisplayGuidance(Model model) {
        return "architectureTemplates/guidanceTemplates/display-guidance";
    }

    @GetMapping("/personalizeDesign")
    public String getPersonalizeDesign(Model model) {
        return "architectureTemplates/personalizeTemplates/personalize-design";
    }

    @GetMapping("/personalizeDesign/designBasic")
    public String getDesignBasic(Model model) {
        return "architectureTemplates/personalizeTemplates/design-basic";
    }

    @GetMapping("/personalizeDesign/designSquare")
    public String getDesignSquare(Model model) {
        return "architectureTemplates/personalizeTemplates/design-square";
    }

    @GetMapping("/personalizeDesign/designParallel")
    public String getDesignParallel(Model model) {
        return "architectureTemplates/personalizeTemplates/design-parallel";
    }

    @GetMapping("/personalizeDesign/designBasic/display")
    public String getDisplayDesignBasic(Model model) {
        return "architectureTemplates/personalizeTemplates/design-basic-display";
    }

    @GetMapping("/personalizeDesign/designSquare/display")
    public String getDisplayDesignSquare(Model model) {
        return "architectureTemplates/personalizeTemplates/design-square-display";
    }

    @GetMapping("/personalizeDesign/designParallel/display")
    public String getDisplayDesignParallel(Model model) {
        return "architectureTemplates/personalizeTemplates/design-parallel-display";
    }

}
