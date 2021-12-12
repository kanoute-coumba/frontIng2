package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.model.CentralByProduction;
import episen.pds.citizens.frontend.model.EquipmentWithConsumption;
import episen.pds.citizens.frontend.service.EnergyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EnergyController {

    private final EnergyService energyService = new EnergyService();

    @GetMapping("/Energy/idb={id_b}")
    public String getEquipmentWithConsumption(Model model,@PathVariable("id_b") final int id_b){
        Iterable<EquipmentWithConsumption> equipmentWithConsumptionIterable= energyService.getEquipmentWithConsumption(id_b);
        Iterable<CentralByProduction> centralByProductionsIterable=energyService.getCentralWithProduction(id_b);
        model.addAttribute("equipmentWithConsumption",equipmentWithConsumptionIterable);
        model.addAttribute("centralWithProduction",centralByProductionsIterable);
        return "equipmentByConsumptionByBuilding";
    }
    @GetMapping("/Energy/idr={id_r}")
    public String getEquipmentWithConsumptionByRoom(Model model, @PathVariable("id_r") final int id_r){
        Iterable<EquipmentWithConsumption> equipmentWithConsumptionIterable= energyService.getEquipmentWithConsumptionByRoom(id_r);
        model.addAttribute("equipmentWithConsumption2",equipmentWithConsumptionIterable);
        return "equipmentByConsumptionByRoom";
    }
}