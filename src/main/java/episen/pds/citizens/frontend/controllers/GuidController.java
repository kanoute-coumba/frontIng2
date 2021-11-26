package episen.pds.citizens.frontend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GuidController {

    @GetMapping("/planAcces")
    public String getPlanAcces(Model model) {
        return "guidTemplates/plan-acces";
    }

    @GetMapping("/guidage")
    public String getGuidage(Model model) {
        return "guidTemplates/guidage";
    }

    @GetMapping("/designInterieur")
    public String getDesignInterieur(Model model) {
        return "guidTemplates/design-interieur";
    }

    @GetMapping("/designInterieur/personalizeDesignBasic")
    public String getPersonalizeDesignBasic(Model model) {
        return "guidTemplates/personalize-design-basic";
    }

    @GetMapping("/designInterieur/personalizeDesignSquare")
    public String getPersonalizeDesignSquare(Model model) {
        return "guidTemplates/personalize-design-square";
    }

    @GetMapping("/designInterieur/personalizeDesignParallel")
    public String getPersonalizeDesignParallel(Model model) {
        return "guidTemplates/personalize-design-parallel";
    }

    @GetMapping("/designInterieur/personalizeDesignBasic/create")
    public String getPersonalizeDesignBasicCreation(@RequestParam(name = "os") String os, @RequestParam(name = "of") String of, Model model) {
        model.addAttribute("os",os);
        model.addAttribute("of",of);
        return "guidTemplates/test";
    }

}
