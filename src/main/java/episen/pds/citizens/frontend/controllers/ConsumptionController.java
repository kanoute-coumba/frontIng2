package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.model.Consumption;
import episen.pds.citizens.frontend.model.DateBeginOrEnd;
import episen.pds.citizens.frontend.model.Login;
import episen.pds.citizens.frontend.model.ObjectForModel;
import episen.pds.citizens.frontend.model.architectureModel.Building;
import episen.pds.citizens.frontend.service.ConsumptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        model.addAttribute("consoIterable", consumptionIterable);
        return "historicRoom";
    }
    @GetMapping("/ConsumptionByIdFloor/{idf}/Between/{db}&{de}")
    public String getConsumptionOfFloorBetweenTwoDate(Model model,
                                                     @PathVariable("idf") int idr,
                                                     @PathVariable("db") long db,
                                                     @PathVariable("de") long de) {
        ArrayList<Consumption> consumptionIterable = consumptionService.getConsumptionByFloorBetweenTwoDate(idr, db, de);
        model.addAttribute("consoIterable", consumptionIterable);
        return "historicFloor";
    }
    @GetMapping("/ConsumptionByIdBuilding/{idb}/Between/{db}&{de}")
    public String getConsumptionOfBuildingBetweenTwoDate(Model model,
                                                      @PathVariable("idb") int idr,
                                                      @PathVariable("db") long db,
                                                      @PathVariable("de") long de) {
        ArrayList<Consumption> consumptionIterable = consumptionService.getConsumptionByBuildingBetweenTwoDate(idr, db, de);
        model.addAttribute("consoIterable", consumptionIterable);
        logger.info("getConsumptionOfBuildingBetweenTwoDate");
        return "historicBuilding";
    }

    @GetMapping("/HistoBuilding")
    public String HistoBuilding(Model model, @ModelAttribute Building house){
        logger.info("HistoBuilding");
        DateBeginOrEnd dateBegin = new DateBeginOrEnd();
        DateBeginOrEnd dateEnd = new DateBeginOrEnd();
        ObjectForModel objectForModel = new ObjectForModel();
        objectForModel.setDateB(dateBegin);
        objectForModel.setDateE(dateEnd);
        objectForModel.setHouse(house);
        model.addAttribute("objectForModel",objectForModel);
        model.addAttribute("dateE",dateEnd);
        model.addAttribute("dateB",dateBegin);
        return "HistoBuilding";
    }
    @PostMapping("/ConsumptionByIdBuilding/")
    public String HistoConsumptionBuilding(Model model,
                                           @ModelAttribute ObjectForModel objectForModel){
        ArrayList<Consumption> consumptionIterable =
                consumptionService.getConsumptionByBuildingBetweenTwoDate(
                        objectForModel.getHouse().getId_building(),
                        objectForModel.getDateB().toLong(),
                        objectForModel.getDateE().toLong());
        model.addAttribute("consoIterable", consumptionIterable);
        logger.info("getConsumptionOfBuildingBetweenTwoDate");
        return "historicBuilding";
    }

}
