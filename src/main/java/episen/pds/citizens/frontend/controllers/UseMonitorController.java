package episen.pds.citizens.frontend.controllers;
import episen.pds.citizens.frontend.model.*;
import episen.pds.citizens.frontend.service.UseMonitorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.logging.Logger;

@Controller
public class UseMonitorController {
    private final UseMonitorService useMonitorService = new UseMonitorService();
    private static final Logger logger = Logger.getLogger(UseMonitorController.class.getName());

    @GetMapping("/configManual/conditions/{id}")
    public String getRoomConditions(Model model, @PathVariable("id") int id_room) {
        Iterable<RoomConditions> listConditions = useMonitorService.getConditionsInRoom(id_room);
        for (RoomConditions row: listConditions) {
            logger.info(row.toString());
        }
        model.addAttribute("conditions", listConditions);
        return "configmanu";
    }

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
        Iterable<Equipment> listEquipmentInRoom = useMonitorService.getEquipmentByRoom(id_room);
        for (Equipment row: listEquipmentInRoom) {
            logger.info(row.toString());
        }
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
}
