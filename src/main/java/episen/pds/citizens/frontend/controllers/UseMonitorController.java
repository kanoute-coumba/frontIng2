package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.model.ConsumptionByBuilding;
import episen.pds.citizens.frontend.model.Equipment;
import episen.pds.citizens.frontend.model.EquipmentAndData;

import episen.pds.citizens.frontend.model.Room;
import episen.pds.citizens.frontend.model.RoomConditions;
import episen.pds.citizens.frontend.service.UseMonitorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.locks.Condition;
import java.util.logging.Logger;

@Controller
public class UseMonitorController {
    private final UseMonitorService useMonitorService = new UseMonitorService();
    private static final Logger logger = Logger.getLogger(UseMonitorController.class.getName());

    @GetMapping("/monitor")
    public String getConsumptionByBuilding(Model model) {
        Iterable<ConsumptionByBuilding> listConsumption = useMonitorService.getConsumptionByBuilding();
        for (ConsumptionByBuilding row: listConsumption) {
            logger.info(row.toString());
        }
        model.addAttribute("consumptionbuilding", listConsumption);
        return "monitor";
    }

    @GetMapping("/listRooms")
    public String getRooms(Model model){
        Iterable<Room> listRoom = useMonitorService.getRooms();
        for (Room row: listRoom) {
            logger.info(row.toString());
        }
        model.addAttribute("rooms", listRoom);
        return "showmyrooms";
    }

    @GetMapping("/configManual/{id}")
    public  String getEquipmentByRoom(Model model, @PathVariable("id") int id_room) {
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
    public String setEquipmentValue(Model model, @PathVariable("id_equipment") int id_equipment, @RequestParam("changevalue") double value, @RequestParam("id_room") int id_room) {
        logger.info("SET: id_equipment="+id_equipment + ", new_value=" + value + ", id_room=" + id_room);
        useMonitorService.setEquipmentValue(id_equipment,value);
        useMonitorService.setEquipmentManu(id_equipment);
        if (value > 0) {
            useMonitorService.setEquipmentOn(id_equipment);
        }
        else {
            useMonitorService.setEquipmentOff(id_equipment);
        }
        return "redirect:/configManual/"+ id_room;
    }

    @PostMapping("/setEquipmentAuto/{id_equipment}")
    public String setEquipmentAuto(Model model, @PathVariable("id_equipment") int id_equipment, @RequestParam("id_room") int id_room) {
        logger.info("SET_AUTO: id_equipment="+ id_equipment + ", id_room=" + id_room);
        useMonitorService.setEquipmentAuto(id_equipment);
        return "redirect:/configManual/"+ id_room;
    }

    @PostMapping("/setEquipmentOn/{id_equipment}")
    public String setEquipmentOn(Model model, @PathVariable("id_equipment") int id_equipment, @RequestParam("id_room") int id_room) {
        logger.info("SET_ON: id_equipment="+ id_equipment + ", id_room=" + id_room);
        useMonitorService.setEquipmentOn(id_equipment);
        return "redirect:/configManual/"+ id_room;
    }

    @PostMapping("/setEquipmentOff/{id_equipment}")
    public String setEquipmentOff(Model model, @PathVariable("id_equipment") int id_equipment, @RequestParam("id_room") int id_room) {
        logger.info("SET_OFF: id_equipment="+ id_equipment + ", id_room=" + id_room);
        useMonitorService.setEquipmentOff(id_equipment);
        return "redirect:/configManual/"+ id_room;
    }
}
