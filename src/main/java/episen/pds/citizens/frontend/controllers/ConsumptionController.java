package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.model.*;
import episen.pds.citizens.frontend.model.architectureModel.Building;
import episen.pds.citizens.frontend.service.ConsumptionService;
import episen.pds.citizens.frontend.service.UsersService;
import episen.pds.citizens.frontend.service.architectureService.BuildingService;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
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
    private final BuildingService buildingService = new BuildingService();
    private final UsersService usersService = new UsersService();

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

    @GetMapping("/HistoBuilding/{idu}")
    public String HistoBuilding(Model model, @PathVariable("idu") int idu){
        logger.info("HistoBuilding");
        ArrayList<Building> buildingIterable = buildingService.getBuildingByIdUser(idu);
        Building house = new Building();
        Users users = usersService.getUsersById(idu);
        if(buildingIterable.size()==1){
            house = buildingIterable.get(0);
            model.addAttribute("house",house);
        }
        DateBeginOrEnd dateBegin = new DateBeginOrEnd();
        DateBeginOrEnd dateEnd = new DateBeginOrEnd();
        ObjectForModel objectForModel = new ObjectForModel();
        objectForModel.setDateB(dateBegin);
        objectForModel.setDateE(dateEnd);
        objectForModel.setHouse(house);
        logger.info(house+"");
        model.addAttribute("user",users);
        model.addAttribute("objectForModel",objectForModel);
        model.addAttribute("dateE",dateEnd);
        model.addAttribute("dateB",dateBegin);
        return "HistoBuilding";
    }

    @PostMapping("/ConsumptionByIdBuilding/{idb}")
    public String HistoConsumptionBuilding(Model model,
                                           @ModelAttribute ObjectForModel objectForModel,
                                           @PathVariable("idb") int idb){
        logger.info(objectForModel.getDateB()+"");
        logger.info(objectForModel.getDateB().toLong()+"");
        ArrayList<Consumption> consumptionIterable =
                consumptionService.getConsumptionByBuildingBetweenTwoDate(
                        idb,
                        objectForModel.getDateB().toLong(),
                        objectForModel.getDateE().toLong());
        model.addAttribute("consoIterable", consumptionIterable);
        logger.info("getConsumptionOfBuildingBetweenTwoDate");
        return "historicBuilding";
    }

}
