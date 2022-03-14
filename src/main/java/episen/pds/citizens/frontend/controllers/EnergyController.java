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
        Double dc = 0.0;
        for (CentralByProduction centralByProduction : centralByProductionsIterable) {
            dc+= Double.parseDouble(centralByProduction.value);
        }
        Double dp = 0.0;
        for (EquipmentWithConsumption equipmentWithConsumption : equipmentWithConsumptionIterable) {
            dp+= Double.parseDouble(equipmentWithConsumption.value);
        }
        model.addAttribute("equipmentWithConsumption",equipmentWithConsumptionIterable);
        model.addAttribute("centralWithProduction",centralByProductionsIterable);
        model.addAttribute("id_b", id_b);
        model.addAttribute("dc",dc);
        model.addAttribute("dp",dp);
        model.addAttribute("somme",dc-dp);
        return "equipmentByConsumptionByBuilding";
    }
    @GetMapping("/Energy/idr={id_r}")
    public String getEquipmentWithConsumptionByRoom(Model model, @PathVariable("id_r") final int id_r){
        Iterable<EquipmentWithConsumption> equipmentWithConsumptionIterable= energyService.getEquipmentWithConsumptionByRoom(id_r);
        Double dp = 0.0;
        for (EquipmentWithConsumption equipmentWithConsumption : equipmentWithConsumptionIterable) {
            dp+= Double.parseDouble(equipmentWithConsumption.value);
        }
        model.addAttribute("equipmentWithConsumption2",equipmentWithConsumptionIterable);
        model.addAttribute("id_r", id_r);
        model.addAttribute("dp",dp);
        return "equipmentByConsumptionByRoom";
    }
}
