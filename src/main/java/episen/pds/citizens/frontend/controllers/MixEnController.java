package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.model.ChoiceAlgoForm;
import episen.pds.citizens.frontend.model.MixEn;
import episen.pds.citizens.frontend.model.MixEnBySite;
import episen.pds.citizens.frontend.model.SimulationEconomicCost;
import episen.pds.citizens.frontend.service.MixEnService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashMap;
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
        return "redirect:/AlgoMix";
    }

    @GetMapping("/GraphEconomicCost")
    public String getGraphEconomicCost(Model model){
        List<Double> l = new ArrayList<>();
        for(int i=0;i<=20;i++){
            l.add((double) (i*200));
        }

        double[] solar = {0.0, 177.88, 185.76, 193.64, 201.52, 209.4, 387.28, 395.15999999999997, 403.04, 410.92, 418.8, 596.68, 604.56, 612.44, 620.3199999999999, 628.2, 806.08, 813.96, 821.84, 829.72, 837.6};
        double[] windTurbine = {0.0, 104.45333333333333, 115.57333333333332, 126.69333333333333, 137.81333333333333, 148.93333333333334, 253.38666666666666, 264.50666666666666, 275.62666666666667, 286.74666666666667, 297.8666666666667, 402.32, 413.44, 424.56, 435.67999999999995, 446.79999999999995, 551.2533333333333, 562.3733333333333, 573.4933333333333, 584.6133333333333, 595.7333333333333};
        double[] hydraulic = {0.0, 217.0, 218.0, 219.0, 220.0, 221.0, 222.0, 223.0, 440.0, 441.0, 442.0, 443.0, 444.0, 445.0, 446.0, 447.0, 664.0, 665.0, 666.0, 667.0, 668.0};
        List<Double> solarList = new ArrayList<>();
        List<Double> windTurbineList = new ArrayList<>();
        List<Double> hydraulicList = new ArrayList<>();
        for(int i=0;i<=20;i++){
            solarList.add(solar[i]);
            windTurbineList.add(windTurbine[i]);
            hydraulicList.add(hydraulic[i]);
        }

        model.addAttribute("abs",l);
        model.addAttribute("solaire", solarList);
        model.addAttribute("eolienne", windTurbineList);
        model.addAttribute("hydraulique", hydraulicList);
        model.addAttribute("simu",new SimulationEconomicCost());

        return "graphEconomicCost";
    }

    @PostMapping("/GraphEconomicCost")
    public String getChoiceAlgoSubmit(@ModelAttribute SimulationEconomicCost m,Model model){
        logger.info("start method");
        HashMap<String,String> simulationData = new HashMap<>();
        simulationData.put("conso", m.getConso());
        simulationData.put("solaireAmort", m.getSolaireAmort());
        simulationData.put("eolienneAmort", m.getEolienneAmort());
        simulationData.put("hydrauliqueAmort", m.getHydrauliqueAmort());

        logger.info(""+simulationData);
        HashMap<String,List<Double>> graphData = mixEnService.simulationEconomicCost(simulationData);
        model.addAttribute("abs", graphData.get("abs"));
        model.addAttribute("solaire", graphData.get("solaire"));
        model.addAttribute("eolienne", graphData.get("eolienne"));
        model.addAttribute("hydraulique", graphData.get("hydraulique"));
        model.addAttribute("simu", new SimulationEconomicCost());
        return "graphEconomicCost";
    }

    @GetMapping("/GraphEnvironmentalCost")
    public String getGraphEnvironmentalCost(Model model){
        HashMap<String,List<Double>> graphData = mixEnService.getGraphDataEnvironmentalCost();
        model.addAttribute("abs", graphData.get("abs"));
        model.addAttribute("solaire", graphData.get("solaire"));
        model.addAttribute("eolienne", graphData.get("eolienne"));
        model.addAttribute("hydraulique", graphData.get("hydraulique"));

        return "graphEnvironmentalCost";
    }

}
