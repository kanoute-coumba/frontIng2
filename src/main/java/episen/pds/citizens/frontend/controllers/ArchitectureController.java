package episen.pds.citizens.frontend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArchitectureController {

    @GetMapping("/accessMap")
    public String getAccessMap(Model model) {
        return "architectureTemplates/access-map";
    }

    @GetMapping("/guidanceOption")
    public String getGuidage(Model model) {
        return "architectureTemplates/guidance-option";
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
