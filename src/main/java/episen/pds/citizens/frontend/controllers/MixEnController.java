package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.model.ChoiceAlgoForm;
import episen.pds.citizens.frontend.model.MixEn;
import episen.pds.citizens.frontend.model.MixEnBySite;
import episen.pds.citizens.frontend.service.MixEnService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
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

        ChoiceAlgoForm currentAlgoChoice = mixEnService.getCurrentAlgoChoice();
        String msg = "";
        // message depending on the choice of the algo
        if(currentAlgoChoice.getChoice().equals("preference")){
            msg += "Algo 1 : Préférence. Avec en choix 1 " + currentAlgoChoice.getPref1() + ", en choix 2 " + currentAlgoChoice.getPref2() + " et en choix 3 " + currentAlgoChoice.getPref3();
        }
        if(currentAlgoChoice.getChoice().equals("proportionequity")){
            msg += "Algo 2 : Proportion égale";
        }
        if(currentAlgoChoice.getChoice().equals("proportionchoice")){
            msg += "Algo 3 : Choix des proportions. Avec " + currentAlgoChoice.getProp1() + "% d'énergie solaire, "+ currentAlgoChoice.getProp2() + "% d'énergie éolienne et " + currentAlgoChoice.getProp3() + "% d'énergie hydraulique.";
        }
        if(currentAlgoChoice.getChoice().equals("preferenceweather")){
            msg += "Algo 4 : Préférence météo";
        }
        if(currentAlgoChoice.getChoice().equals("economic")){
            msg += "Algo 5 : Préférence économique";
        }
        if(currentAlgoChoice.getChoice().equals("environmental")){
            msg += "Algo 6 Préférence environnementale";
        }
        model.addAttribute("choixActuel",msg);

        //ChoiceAlgoForm newChoiceAlgo = new ChoiceAlgoForm();
        //newChoiceAlgo.setIdChoiceAlgo(currentAlgoChoice.getIdChoiceAlgo()); //we retrieve the id of the choice of the ago
        model.addAttribute("choix",new ChoiceAlgoForm());
        logger.info(""+mixEnService.getCurrentAlgoChoice());
        return "choiceAlgo";
    }

    @PostMapping("/AlgoMix")
    public String getChoiceAlgoSubmit(@ModelAttribute ChoiceAlgoForm model){
        model.setIdChoiceAlgo(mixEnService.getCurrentAlgoChoice().getIdChoiceAlgo());
        mixEnService.saveAlgoChoice(model);
        logger.info(""+model.toString());
        return "redirect:/Municipality"; //TODO "redirect:/AlgoMix"
    }

    @GetMapping("/GraphEconomicCost")
    public String getGraphEconomicCost(Model model){
        List<Double> l = new ArrayList<>();
        for(int i=0;i<=20;i++){
            l.add((double) (i*200));
        }
        model.addAttribute("abs",l);
        return "graphEconomicCost";
    }
}
