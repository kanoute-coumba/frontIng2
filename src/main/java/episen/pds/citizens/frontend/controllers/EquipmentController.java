package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.model.EquipmentWithConsumption;
import episen.pds.citizens.frontend.service.EquipmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EquipmentController {

    private EquipmentService equipmentService = new EquipmentService();

    @GetMapping("/EquipmentWithConsumption")
    public String getEquipmentWithConsumption(Model model){
        Iterable<EquipmentWithConsumption> equipmentWithConsumptionIterable=equipmentService.getEquipmentWithConsumption();
        model.addAttribute("equipmentWithConsumption",equipmentWithConsumptionIterable);
        return "equipmentByConsumption";
    }
}
