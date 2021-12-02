package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.model.EquipmentWithConsumption;
import episen.pds.citizens.frontend.service.EnergyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EquipmentController {

    private EnergyService energyService = new EnergyService();

    @GetMapping("/EquipmentWithConsumption/{id_b}")
    public String getEquipmentWithConsumption(Model model,@PathVariable("id_b") final int id_b){
        Iterable<EquipmentWithConsumption> equipmentWithConsumptionIterable= energyService.getEquipmentWithConsumption(id_b);
        model.addAttribute("equipmentWithConsumption",equipmentWithConsumptionIterable);
        return "equipmentByConsumption";
    }
}
