package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.model.*;
import episen.pds.citizens.frontend.service.OverrunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

@Controller
public class OverrunController {

    private static final Logger logger = Logger.getLogger(OverrunController.class.getName());

    @Autowired
    OverrunService overrunService;

    @GetMapping("/attribmock")
    public String getAttribAfterMock(Model model) {
        Iterable<Attribution> allAttrib = overrunService.getAttribAfterMock();
        model.addAttribute("attribution", allAttrib);
        return "attribution";
    }

    @GetMapping("/consomock")
    public String getListTest(Model model) {
        Iterable<ConsoByDay> allConso = overrunService.getConsoAfterMock();
        model.addAttribute("consumption", allConso);
        return "conso";
    }

    @GetMapping("/attribution")
    public String getAttribution(Model model) {
        Iterable<Attribution> listAttribution = overrunService.getAttribution();
        model.addAttribute("attribution", listAttribution);

        return "attribution";

    }

    @GetMapping("/conso")
    public String getConsumption(Model model) {
        Iterable<ConsoByDay> listConso = overrunService.getConsumption();
        model.addAttribute("consumption", listConso);

        return "conso";
    }

    @GetMapping("/peak")
    public String getPeakDay(Model model) {
        Iterable<PeakDay> listPeak = overrunService.getPeakDay();
        model.addAttribute("peak", listPeak);

        return "peak";
    }

    @GetMapping("/municipality")
           public String authForm() {
            return "municipality";
        }

    @RequestMapping(method = RequestMethod.POST, value = "/principal")
    public String submitProfil() {
        return "principal";
    }

    @GetMapping("/statistiques")
    public String getPeak(Model model) {
        Iterable<PeakYear> nbrePeak = overrunService.getPeak();
        model.addAttribute("peak", nbrePeak);

        return "statistiques";
    }

    @GetMapping("/2020")
    public String getPeak20(Model model) {
        Iterable<PeakMonth> nbrePeak = overrunService.getPeak20();
        model.addAttribute("peak", nbrePeak);

        return "peakByMonth";
    }

    @GetMapping("/2021")
    public String getPeak21(Model model) {
        Iterable<PeakMonth> nbrePeak = overrunService.getPeak21();
        model.addAttribute("peak", nbrePeak);

        return "peakByMonth";
    }

    @GetMapping("/2022")
    public String getPeak22(Model model) {
        Iterable<PeakMonth> nbrePeak = overrunService.getPeak22();
        model.addAttribute("peak", nbrePeak);

        return "peakByMonth";
    }

}