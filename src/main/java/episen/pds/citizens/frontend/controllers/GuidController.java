package episen.pds.citizens.frontend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GuidController {

    @GetMapping("/accessMap")
    public String getAccessMap(Model model) {
        return "guidTemplates/access-map";
    }

    @GetMapping("/guidanceOption")
    public String getGuidage(Model model) {
        return "guidTemplates/guidance-option";
    }

    @GetMapping("/personalizeDesign")
    public String getPersonalizeDesign(Model model) {
        return "guidTemplates/personalizeTemplates/personalize-design";
    }

    @GetMapping("/personalizeDesign/designBasic")
    public String getDesignBasic(Model model) {
        return "guidTemplates/personalizeTemplates/design-basic";
    }

    @GetMapping("/personalizeDesign/designSquare")
    public String getDesignSquare(Model model) {
        return "guidTemplates/personalizeTemplates/design-square";
    }

    @GetMapping("/personalizeDesign/designParallel")
    public String getDesignParallel(Model model) {
        return "guidTemplates/personalizeTemplates/design-parallel";
    }

    @GetMapping("/personalizeDesign/designBasic/display")
    public String getDisplayDesignBasic(Model model) {
        return "guidTemplates/personalizeTemplates/design-basic-display";
    }

    @GetMapping("/personalizeDesign/designSquare/display")
    public String getDisplayDesignSquare(Model model) {
        return "guidTemplates/personalizeTemplates/design-square-display";
    }

    @GetMapping("/personalizeDesign/designParallel/display")
    public String getDisplayDesignParallel(Model model) {
        return "guidTemplates/personalizeTemplates/design-parallel-display";
    }

}
