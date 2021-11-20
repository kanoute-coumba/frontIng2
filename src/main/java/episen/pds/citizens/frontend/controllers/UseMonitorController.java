package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.service.UseMonitorService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


public class UseMonitorController {
    private UseMonitorService useMonitorService = new UseMonitorService();

    @GetMapping("/configManual")
    public String getCurrentConfig(Model model) {
        return "configmanu";
    }

    @GetMapping("/monitor")
    public String getConsumptionByBuilding(Model model) {
        return "consumption by building";
    }

}
