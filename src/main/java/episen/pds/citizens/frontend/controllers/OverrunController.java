package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.model.Attribution;
import episen.pds.citizens.frontend.model.Consumption;
import episen.pds.citizens.frontend.model.MixEn;
import episen.pds.citizens.frontend.service.OverrunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class OverrunController {

    private static final Logger logger = Logger.getLogger(OverrunController.class.getName());

    @Autowired
    OverrunService overrunService = new OverrunService();

    @GetMapping("/overrun")
    public String getAttribution(Model model) {
        Iterable<Attribution> listAttribution = overrunService.getAttribution();
        for(Attribution att : listAttribution) {
            logger.info(att.toString());
        }
        model.addAttribute("attribution", listAttribution);
        return "attribution";
        //return listAttribution;
    }
    @GetMapping("/conso")
    public String getConsumption(Model model) {
        Iterable<Consumption> listConso = overrunService.getConsumption();
        for(Consumption conso : listConso) {
            logger.info(conso.toString());
        }
        model.addAttribute("consumption", listConso);
        return "conso";
    }
}
