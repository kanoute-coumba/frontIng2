package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.model.OccupationRate;
import episen.pds.citizens.frontend.service.OccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class OccupationController {

        private static final Logger logger = Logger.getLogger(OccupationController.class.getName());

        @Autowired
        OccupationService occupationService;

        @GetMapping("/2020rate")
        public String get2020rate(Model model) {
            Iterable<OccupationRate> occupationRate = occupationService.getOccupationRate();
            model.addAttribute("occupationRate", occupationRate);
            return "rateByBuilding";
        }

        @GetMapping("/2021rate")
        public String get2021rate(Model model) {
            Iterable<OccupationRate> occupationRate = occupationService.getOccupationRate();
            model.addAttribute("occupationRate", occupationRate);
            return "rateByBuilding";
        }

        @GetMapping("/2022rate")
        public String get2022rate(Model model) {
            Iterable<OccupationRate> occupationRate = occupationService.getOccupationRate();
            model.addAttribute("occupationRate", occupationRate);
            return "rateByBuilding";
        }

}
