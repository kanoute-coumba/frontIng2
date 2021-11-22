package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.model.MixEn;
import episen.pds.citizens.frontend.service.MixEnService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MixEnController {
    private MixEnService mixEnService = new MixEnService();

    @GetMapping("/Mix")
    public String getListTest(Model model) {

        Iterable<MixEn> listTest = mixEnService.getMixEn();
        for(MixEn m : listTest) {
            if (m.getAdress().equals("1 rue panneau solaire")) {
                model.addAttribute("panneauSolaire", m.getMix());
            }
            if (m.getAdress().equals("1 rue eolienne")) {
                model.addAttribute("eolienne", m.getMix());
            }
        }
        return "currentMix";
    }
}
