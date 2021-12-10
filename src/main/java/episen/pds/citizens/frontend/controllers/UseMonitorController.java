package episen.pds.citizens.frontend.controllers;
import episen.pds.citizens.frontend.model.ConsumptionByBuilding;
import episen.pds.citizens.frontend.model.RoomConditions;
import episen.pds.citizens.frontend.model.Equipment;
import episen.pds.citizens.frontend.model.RoomsWithConsumption;
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

    @GetMapping("/configManual/{id}")
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
        Iterable<RoomsWithConsumption> listRoom = useMonitorService.getRooms();
        for (RoomsWithConsumption row: listRoom) {
            logger.info(row.toString());
        }
        model.addAttribute("rooms", listRoom);
        return "showmyrooms";
    }

    @GetMapping("/configManual/{id}")
    public  String getEquipmentByRoom(Model model, @PathVariable("id") int id_room) {
        Iterable<Equipment> listEquipmentInRoom = useMonitorService.getEquipmentByRoom(id_room);
        for (Equipment row: listEquipmentInRoom) {
            logger.info(row.toString());
        }
        model.addAttribute("equipments", listEquipmentInRoom);
        return "configmanu";
    }

}
