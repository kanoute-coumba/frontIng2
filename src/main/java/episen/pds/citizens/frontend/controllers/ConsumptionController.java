package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.model.Consumption;
import episen.pds.citizens.frontend.service.ConsumptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ConsumptionController {

    private final ConsumptionService consumptionService = new ConsumptionService();

    @GetMapping("/ConsumptionByIdEquipment/{ide}")
    public String getConsumptionOfEquipment(Model model, @PathVariable("ide") int ide){
        Iterable<Consumption> consumptionIterable = consumptionService.getConsumptionByEquipment(ide);
        model.addAttribute("consoIterable",consumptionIterable);
        return "histoEquipment";
    }
    @GetMapping("")
    public String getConsumptionOfEquipmentBetweenTwoDate(Model model,
                                                          @PathVariable("ide") int ide,
                                                          @PathVariable("db") long db,
                                                          @PathVariable("de") long de){
        Iterable<Consumption> consumptionIterable = consumptionService.getConsumptionByEquipmentBetweenTwoDate(ide,db,de);
        model.addAttribute("consoIterable",consumptionIterable);
    return "jenesaispas";
    }

}
