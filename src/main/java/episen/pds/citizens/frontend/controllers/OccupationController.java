package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.model.Attribution;
import episen.pds.citizens.frontend.model.Tenant;
import episen.pds.citizens.frontend.service.OccupationService;
import episen.pds.citizens.frontend.service.OverrunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class OccupationController {

        private static final Logger logger = Logger.getLogger(episen.pds.citizens.frontend.controllers.OccupationController.class.getName());

        @Autowired
        OccupationService occupationService;

        @GetMapping("/tenant")
        public String getTenant(Model model) {
            Iterable<Tenant> alltenant = occupationService.getTenant();
            model.addAttribute("tenant", alltenant);
            return "tenant";
        }
}
