package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.model.*;
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

        @GetMapping("/tenant")
        public String getTenant(Model model) {
            Iterable<Tenant> allTanant = occupationService.getTenant();
            model.addAttribute("tenant", allTanant);
            return "tenant";
        }

        @GetMapping("/dwp_buildings")
        public String getDWPbuildings(Model model) {
            Iterable<DWPbyBuilding> dwp = occupationService.getDWPbuildings();
            model.addAttribute("dwpByBuilding", dwp);
            return "dwpByBuilding";
        }

        @GetMapping("/tenantdetails")
        public String getTenantDetails(Model model) {
            Iterable<TenantDetails> tenantdetails = occupationService.getTenantDetails();
            model.addAttribute("tenantdetails", tenantdetails);
            return "tenantdetails";
        }

        @GetMapping("/rentyearcounter")
        public String getCounterByYear(Model model) {
            Iterable<RentCounterByYear> counter = occupationService.getRentCounterByYear();
            model.addAttribute("rentCounterByYear", counter);
            return "rentCounterByYear";
        }

        @GetMapping("/occupation_rate")
        public String getOccupationRate(Model model) {
            Iterable<OccupationRate> occupationRate = occupationService.getOccupationRate();
            model.addAttribute("occupationRate", occupationRate);
            return "occupationRate";
        }
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
