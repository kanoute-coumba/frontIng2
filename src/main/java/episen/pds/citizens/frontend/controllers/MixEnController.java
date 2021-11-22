package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.model.MixEn;
import episen.pds.citizens.frontend.model.MixEnBySite;
import episen.pds.citizens.frontend.service.MixEnService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MixEnController {
    private MixEnService mixEnService = new MixEnService();

    @GetMapping("/Mix")
    public String getListTest(Model model) {

        Iterable<MixEn> listMixEn = mixEnService.getMixEn();
        for(MixEn m : listMixEn) {
            if (m.getNameBuilding().equals("solaire")) {
                model.addAttribute("panneauSolaire", m.getMix());
            }
            if (m.getNameBuilding().equals("eolienne")) {
                model.addAttribute("eolienne", m.getMix());
            }
        }

        Iterable<MixEnBySite> listMixEnByEn = mixEnService.getMixEnBySite();
        model.addAttribute("listMixEnByEn", listMixEnByEn);
        return "currentMix";
    }
}
