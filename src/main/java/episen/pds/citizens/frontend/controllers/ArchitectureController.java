package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.service.architectureService.BuildingService;
import episen.pds.citizens.frontend.service.architectureService.ConfigurationService;
import episen.pds.citizens.frontend.service.architectureService.FloorService;
import episen.pds.citizens.frontend.service.architectureService.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArchitectureController {

    @Autowired
    private BuildingService buildingService;
    @Autowired
    private FloorService floorService;
    @Autowired
    private SpaceService spaceService;
    @Autowired
    private ConfigurationService configurationService;

    // ******************** Plan d'accès ******************** //

    @GetMapping("/accessMap")
    public String getAccessMap(Model model) {
        model.addAttribute("buildings", buildingService.getAllBuildings());
        return "architectureTemplates/accessTemplates/access-map";
    }

    @GetMapping("/accessMap/display")
    public String getDisplayAccessMap(Model model, @RequestParam("floors") String name_floor) {
        model.addAttribute("design", floorService.getDesignOfFloor(name_floor));
        model.addAttribute("offices", spaceService.getSpacesOfFloorByType(name_floor, "Bureau"));
        model.addAttribute("meetingRooms", spaceService.getSpacesOfFloorByType(name_floor, "Salle de reunion"));
        model.addAttribute("individualRooms", spaceService.getSpacesOfFloorByType(name_floor, "Salle individuelle"));
        model.addAttribute("openSpaces", spaceService.getSpacesOfFloorByType(name_floor, "Espace ouvert"));
        return "architectureTemplates/accessTemplates/display-access-map";
    }

    // ********************************************************* //

    // ******************** Design intérieur ******************** //

    @GetMapping("/personalizeDesign")
    public String getPersonalizeDesign(Model model) {
        return "architectureTemplates/personalizeTemplates/personalize-design";
    }

    @GetMapping("/personalizeDesign/designPanoramic")
    public String getDesignPanoramic(Model model) {
        return "architectureTemplates/personalizeTemplates/design-panoramic";
    }

    @GetMapping("/personalizeDesign/designSquare")
    public String getDesignSquare(Model model) {
        return "architectureTemplates/personalizeTemplates/design-square";
    }

    @GetMapping("/personalizeDesign/designParallel")
    public String getDesignParallel(Model model) {
        return "architectureTemplates/personalizeTemplates/design-parallel";
    }

    @GetMapping("/personalizeDesign/designPanoramic/display")
    public String getDisplayDesignPanoramic(Model model) {
        model.addAttribute("buildings", buildingService.getAllBuildings());
        return "architectureTemplates/personalizeTemplates/design-panoramic-display";
    }

    @GetMapping("/personalizeDesign/designSquare/display")
    public String getDisplayDesignSquare(Model model) {
        model.addAttribute("buildings", buildingService.getAllBuildings());
        return "architectureTemplates/personalizeTemplates/design-square-display";
    }

    @GetMapping("/personalizeDesign/designParallel/display")
    public String getDisplayDesignParallel(Model model) {
        model.addAttribute("buildings", buildingService.getAllBuildings());
        return "architectureTemplates/personalizeTemplates/design-parallel-display";
    }

    @GetMapping("/personalizeDesign/saveDesign")
    public String getSaveDesign(Model model) {
        return "architectureTemplates/personalizeTemplates/save-design";
    }

    // ************************************************************ //

    // ******************** Mes Configurations ******************** //

    @GetMapping("/myConfigurations")
    public String getMyConfigurations(Model model) {
        model.addAttribute("configurations", configurationService.getAllConfigurations());
        return "architectureTemplates/configurationTemplates/configuration-saved";
    }

    // ************************************************************ //

    // ******************** Se faire guider ******************** //

    @GetMapping("/guidanceOption")
    public String getGuidanceOption(Model model) {
        model.addAttribute("buildings", buildingService.getAllBuildings());
        return "architectureTemplates/guidanceTemplates/guidance-option";
    }

    @GetMapping("/guidanceOption/display")
    public String getDisplayGuidance(Model model, @RequestParam("floors") String name_floor, @RequestParam("spaces") String name_space) {
        model.addAttribute("design", floorService.getDesignOfFloor(name_floor));
        model.addAttribute("offices", spaceService.getSpacesOfFloorByType(name_floor, "Bureau"));
        model.addAttribute("meetingRooms", spaceService.getSpacesOfFloorByType(name_floor, "Salle de reunion"));
        model.addAttribute("individualRooms", spaceService.getSpacesOfFloorByType(name_floor, "Salle individuelle"));
        model.addAttribute("openSpaces", spaceService.getSpacesOfFloorByType(name_floor, "Espace ouvert"));
        model.addAttribute("space", spaceService.getSpaceByName(name_space));
        return "architectureTemplates/guidanceTemplates/display-guidance";
    }

    // ********************************************************** //

}
