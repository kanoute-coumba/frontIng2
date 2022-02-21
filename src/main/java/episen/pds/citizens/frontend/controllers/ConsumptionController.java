package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.model.Consumption;
import episen.pds.citizens.frontend.service.ConsumptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Logger;

@Controller
public class ConsumptionController {
    private static final Logger logger = Logger.getLogger(ConsumptionController.class.getName());
    private final ConsumptionService consumptionService = new ConsumptionService();

    @GetMapping("/ConsumptionByIdEquipment/{ide}")
    public String getConsumptionOfEquipment(Model model, @PathVariable("ide") int ide) {
        Iterable<Consumption> consumptionIterable = consumptionService.getConsumptionByEquipment(ide);
        model.addAttribute("consoIterable", consumptionIterable);
        return "histoEquipment";
    }

    @GetMapping("/ConsumptionByIdEquipment/{ide}/Between/{db}&{de}")
    public String getConsumptionOfEquipmentBetweenTwoDate(Model model,
                                                          @PathVariable("ide") int ide,
                                                          @PathVariable("db") long db,
                                                          @PathVariable("de") long de) {
        Iterable<Consumption> consumptionIterable = consumptionService.getConsumptionByEquipmentBetweenTwoDate(ide, db, de);
        model.addAttribute("consoIterable", consumptionIterable);
        return "histoEquipment";
    }

    @GetMapping("/ConsumptionByIdRoom/{idr}/Between/{db}&{de}")
    public String getConsumptionOfRoomBetweenTwoDate(Model model,
                                                     @PathVariable("idr") int idr,
                                                     @PathVariable("db") long db,
                                                     @PathVariable("de") long de) {
        ArrayList<Consumption> consumptionIterable = consumptionService.getConsumptionByRoomBetweenTwoDate(idr, db, de);
        logger.info("nb lignes" + consumptionIterable.size());
        logger.info("json" + consumptionIterable);
        model.addAttribute("consoIterable", consumptionIterable);

        return "historicRoom";
    }

}
