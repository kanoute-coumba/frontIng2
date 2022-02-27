package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.model.ChoixAlgoForm;
import episen.pds.citizens.frontend.model.MixEn;
import episen.pds.citizens.frontend.model.MixEnBySite;
import episen.pds.citizens.frontend.service.MixEnService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.logging.Logger;

@Controller
public class MixEnController {
    private static final Logger logger = Logger.getLogger(MixEnController.class.getName());

    private MixEnService mixEnService = new MixEnService();

    // controller Current Mix

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
            if (m.getNameBuilding().equals("hydraulique")) {
                model.addAttribute("hydraulique", m.getMix());
            }
        }

        Iterable<MixEnBySite> listMixEnBySite = mixEnService.getMixEnBySite();
        model.addAttribute("listMixEnBySite", listMixEnBySite);

        for(MixEnBySite m : listMixEnBySite){
            logger.info(m.toString());
        }
        return "currentMix";
    }

    // controller Choice Algo for the Mix

    @GetMapping("/AlgoMix")
    public String getChoiceAlgo(Model model){
        model.addAttribute("choix",new ChoixAlgoForm());

        return "choiceAlgo";
    }

    @PostMapping("/AlgoMix")
    public String getChoiceAlgoSubmit(@ModelAttribute ChoixAlgoForm model){
        //String t= (String) model.getAttribute("choix_algo");
        logger.info(""+model.getChoice());
        logger.info(""+model.toString());

        return "redirect:/Municipality"; //TODO
    }
}
