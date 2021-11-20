package episen.pds.citizens.frontend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuidController {

    @GetMapping("/planAcces")
    public String getPlanAcces(Model model) {
        return "guidTemplates/plan-acces";
    }

    @GetMapping("/designInterieur")
    public String getDesignInterieur(Model model) {
        return "guidTemplates/design-interieur";
    }

    @GetMapping("/guidage")
    public String getGuidage(Model model) {
        return "guidTemplates/guidage";
    }

}
