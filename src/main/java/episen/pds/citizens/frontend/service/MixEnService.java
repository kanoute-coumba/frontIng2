package episen.pds.citizens.frontend.service;

import episen.pds.citizens.frontend.model.ChoiceAlgoForm;
import episen.pds.citizens.frontend.model.MixEn;
import episen.pds.citizens.frontend.model.MixEnBySite;
import episen.pds.citizens.frontend.repository.MixEnProxy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public class MixEnService {

    @Autowired
    private MixEnProxy mixEnProxy = new MixEnProxy();
    private static final Logger logger = Logger.getLogger(MixEnProxy.class.getName());

    public Iterable<MixEn> getMixEn(){
        return mixEnProxy.getCurrentMixEn();
    }

    public Iterable<MixEnBySite> getMixEnBySite(){
        return mixEnProxy.getCurrentMixEnBySite();
    }

    public ChoiceAlgoForm getCurrentAlgoChoice(){ return mixEnProxy.getCurrentAlgoChoice();}

    public ChoiceAlgoForm saveAlgoChoice(ChoiceAlgoForm choiceAlgo){return mixEnProxy.saveAlgoChoice(choiceAlgo);}

    public HashMap<String, List<Double>> simulationEconomicCost(HashMap<String,String> e){return mixEnProxy.simulationEconomicCost(e);}

    public HashMap<String, List<Double>> getGraphDataEnvironmentalCost(){return mixEnProxy.getGraphDataEnvironmentalCost();}

}
