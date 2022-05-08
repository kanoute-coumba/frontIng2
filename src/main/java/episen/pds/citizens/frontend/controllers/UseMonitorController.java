package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.model.*;

import episen.pds.citizens.frontend.service.ConsumptionService;
import episen.pds.citizens.frontend.service.UseMonitorService;
import episen.pds.citizens.frontend.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.logging.Logger;

@Controller
public class UseMonitorController {
    @Autowired
    private UseMonitorService useMonitorService;
    @Autowired
    private ConsumptionService consumptionService;
    private static final Logger logger = Logger.getLogger(UseMonitorController.class.getName());

    @Autowired
    UsersService usersService;
    @GetMapping("/monitor")
    public String getConsumptionByBuilding(Model model) {
        Iterable<ConsumptionByBuilding> listConsumption = useMonitorService.getConsumptionByBuilding();
        for (ConsumptionByBuilding row: listConsumption) {
            logger.info(row.toString());
        }
        model.addAttribute("consumptionbuilding", listConsumption);
        return "monitor";
    }

    @GetMapping("/listRooms/{id_user}")
    public String getRooms(Model model, @PathVariable("id_user") int id_user){
        Iterable<Room> listRoom = useMonitorService.getRooms(id_user);
        for (Room row: listRoom) {
            logger.info(row.toString());
        }
        Users user = usersService.getUsersById(id_user);
        model.addAttribute("rooms", listRoom);
        model.addAttribute("user", user);
        return "showmyrooms";
    }

    @GetMapping("/configManual/{id_user}/{id_room}")
    public  String getEquipmentByRoom(Model model, @PathVariable("id_room") int id_room, @PathVariable("id_user") int id_user) {
        logger.info("Id_room="+id_room);
        Iterable<EquipmentAndData> listEquipmentInRoom = useMonitorService.getEquipmentByRoom(id_room);
        for (EquipmentAndData row: listEquipmentInRoom) {
            logger.info(row.toString());
        }
        logger.info("GET_BEST_COND: id_room=" + id_room);
        RoomConditions best_cond = useMonitorService.getConditionsInRoom(id_room);
        logger.info(best_cond.toString());
        model.addAttribute("best_cond",best_cond);
        logger.info("GET_CURRENT_COND: id_room=" + id_room);
        RoomConditions current_cond = useMonitorService.getCurrentConditionsInRoom(id_room);
        logger.info(current_cond.toString());
        model.addAttribute("current_cond",current_cond);
        model.addAttribute("equipments", listEquipmentInRoom);
        Users user = usersService.getUsersById(id_user);
        model.addAttribute("user", user);
        return "configmanu";
    }

    @GetMapping("/configManual")
    public  String getAllEquipments(Model model) {
        Iterable<Equipment> listEquipments = useMonitorService.getAllEquipments();
        for (Equipment row: listEquipments) {
            logger.info(row.toString());
        }
        model.addAttribute("equipments", listEquipments);
        return "configmanu";
    }

    @PostMapping("/setEquipmentValue/{id_equipment}")
    public String setEquipmentValue(Model model, @PathVariable("id_equipment") int id_equipment, @RequestParam("changevalue") double value, @RequestParam("id_room") int id_room, @RequestParam("id_user") int id_user) {
        logger.info("SET: id_equipment="+id_equipment + ", new_value=" + value + ", id_room=" + id_room + ", id_user=" + id_user);
        useMonitorService.setEquipmentValue(id_equipment,value);
        useMonitorService.setEquipmentManu(id_equipment);
        if (value > 0) {
            useMonitorService.setEquipmentOn(id_equipment);
        }
        else {
            useMonitorService.setEquipmentOff(id_equipment);
        }

        return "redirect:/configManual/"+ id_user + "/" + id_room;
    }

    @PostMapping("/setEquipmentAuto/{id_equipment}")
    public String setEquipmentAuto(Model model, @PathVariable("id_equipment") int id_equipment, @RequestParam("id_room") int id_room, @RequestParam("id_user") int id_user) {
        logger.info("SET_AUTO: id_equipment="+ id_equipment + ", id_room=" + id_room+ ", id_user=" + id_user + ", id_user=" + id_user);
        useMonitorService.setEquipmentAuto(id_equipment);
        return "redirect:/configManual/"+ id_user + "/" + id_room;
    }

    @PostMapping("/setEquipmentOn/{id_equipment}")
    public String setEquipmentOn(Model model, @PathVariable("id_equipment") int id_equipment, @RequestParam("id_room") int id_room, @RequestParam("id_user") int id_user) {
        logger.info("SET_ON: id_equipment="+ id_equipment + ", id_room=" + id_room + ", id_user=" + id_user);
        useMonitorService.setEquipmentOn(id_equipment);
        return "redirect:/configManual/"+ id_room;
    }

    @PostMapping("/setEquipmentOff/{id_equipment}")
    public String setEquipmentOff(Model model, @PathVariable("id_equipment") int id_equipment, @RequestParam("id_room") int id_room, @RequestParam("id_user") int id_user) {
        logger.info("SET_OFF: id_equipment="+ id_equipment + ", id_room=" + id_room + ", id_user=" + id_user);
        useMonitorService.setEquipmentOff(id_equipment);
        return "redirect:/configManual/"+ id_room;
    }
/*
    @GetMapping("/ConsumptionByIdEquipment/{ide}")
    public String getConsumptionOfEquipment(Model model, @PathVariable("ide") int ide) {
        Iterable<Consumption> consumptionIterable = consumptionService.getConsumptionByEquipment(ide);
        model.addAttribute("consoIterable", consumptionIterable);
        return "monitor";
    }

    @GetMapping("/ConsumptionByIdEquipment/{ide}/Between/{db}&{de}")
    public String getConsumptionOfEquipmentBetweenTwoDate(Model model,
                                                          @PathVariable("ide") int ide,
                                                          @PathVariable("db") long db,
                                                          @PathVariable("de") long de) {
        Iterable<Consumption> consumptionIterable = consumptionService.getConsumptionByEquipmentBetweenTwoDate(ide, db, de);
        model.addAttribute("consoIterable", consumptionIterable);
        return "monitor";
    }


    @GetMapping("/ConsumptionByIdRoom/{idr}/Between/{db}&{de}")
    public String getConsumptionOfRoomBetweenTwoDate(Model model,
                                                     @PathVariable("idr") int idr,
                                                     @PathVariable("db") long db,
                                                     @PathVariable("de") long de) {
        ArrayList<Consumption> consumptionIterable = consumptionService.getConsumptionByRoomBetweenTwoDate(idr, db, de);
        model.addAttribute("consoIterable", consumptionIterable);
        return "monitor";
    }
    @GetMapping("/ConsumptionByIdFloor/{idf}/Between/{db}&{de}")
    public String getConsumptionOfFloorBetweenTwoDate(Model model,
                                                      @PathVariable("idf") int idr,
                                                      @PathVariable("db") long db,
                                                      @PathVariable("de") long de) {
        ArrayList<Consumption> consumptionIterable = consumptionService.getConsumptionByFloorBetweenTwoDate(idr, db, de);
        model.addAttribute("consoIterable", consumptionIterable);
        return "monitor";
    }
    @GetMapping("/ConsumptionByIdBuilding/{idf}/Between/{db}&{de}")
    public String getConsumptionOfBuildingBetweenTwoDate(Model model,
                                                         @PathVariable("idf") int idr,
                                                         @PathVariable("db") long db,
                                                         @PathVariable("de") long de) {
        ArrayList<Consumption> consumptionIterable = consumptionService.getConsumptionByBuildingBetweenTwoDate(idr, db, de);
        model.addAttribute("consoIterable", consumptionIterable);
        logger.info("getConsumptionOfBuildingBetweenTwoDate");
        return "monitor";
    }
 */
}
