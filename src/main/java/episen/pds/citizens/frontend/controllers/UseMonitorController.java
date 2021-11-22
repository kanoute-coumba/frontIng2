package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.model.RoomsWithConsumption;
import episen.pds.citizens.frontend.model.Test;
import episen.pds.citizens.frontend.service.UseMonitorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UseMonitorController {
    private UseMonitorService useMonitorService = new UseMonitorService();

    @GetMapping("/configManual")
    public String getCurrentConfig(Model model) {
        return "configmanu";
    }

    @GetMapping("/monitor")
    public String getConsumptionByBuilding(Model model) {
        return "monitor";
    }

    @GetMapping("/listRooms")
    public String getRooms(Model model){
        Iterable<RoomsWithConsumption> listRoom = useMonitorService.getRooms();
        model.addAttribute("room", listRoom);
        return "configmanu";
    }
}
