package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.model.architectureModel.Building;
import episen.pds.citizens.frontend.service.architectureService.BuildingService;
import episen.pds.citizens.frontend.service.architectureService.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class ArchitectureController {

    @Autowired
    private BuildingService buildingService;
    @Autowired
    private SpaceService spaceService;

    @GetMapping("/accessMap")
    public String getAccessMap(Model model) {
        model.addAttribute("buildings", buildingService.getAllBuildings());
        return "architectureTemplates/accessTemplates/access-map";
    }

    @GetMapping("/accessMap/display{name_floor}")
    public String getDisplayAccessMap(Model model, @PathVariable final String name_floor) {
        model.addAttribute("offices",spaceService.getSpacesOfFloorByType(name_floor,"Bureau"));
        model.addAttribute("meetingRooms",spaceService.getSpacesOfFloorByType(name_floor,"Salle de reunion"));
        model.addAttribute("individualRooms",spaceService.getSpacesOfFloorByType(name_floor,"Salle individuelle"));
        model.addAttribute("openSpaces",spaceService.getSpacesOfFloorByType(name_floor,"Espace ouvert"));
        return "architectureTemplates/accessTemplates/display-access-map";
    }

    @GetMapping("/guidanceOption")
    public String getGuidanceOption(Model model) {
        model.addAttribute("buildings", buildingService.getAllBuildings());
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
