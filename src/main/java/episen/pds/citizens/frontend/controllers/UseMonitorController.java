package episen.pds.citizens.frontend.controllers;
import episen.pds.citizens.frontend.model.RoomConditions;
import episen.pds.citizens.frontend.model.Equipment;
import episen.pds.citizens.frontend.model.RoomsWithConsumption;
import episen.pds.citizens.frontend.service.UseMonitorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UseMonitorController {
    private final UseMonitorService useMonitorService = new UseMonitorService();

    @GetMapping("/configManual/{id}")
    public String getRoomConditions(Model model, @PathVariable("id") int id_room) {
        Iterable<RoomConditions> listConditions = useMonitorService.getConditionsInRoom(id_room);
        model.addAttribute("conditions", listConditions);
        return "configmanu";
    }

    @GetMapping("/monitor")
    public String getConsumptionByBuilding(Model model) {
        return "monitor";
    }

    @GetMapping("/listRooms")
    public String getRooms(Model model){
        Iterable<RoomsWithConsumption> listRoom = useMonitorService.getRooms();
        model.addAttribute("rooms", listRoom);
        return "showmyrooms";
    }

    @GetMapping("/configManual/{id}")
    public  String getEquipmentByRoom(Model model, @PathVariable("id") int id_room) {
        Iterable<Equipment> listEquipmentInRoom = useMonitorService.getEquipmentByRoom(id_room);
        model.addAttribute("equipments", listEquipmentInRoom);
        return "configmanu";
    }
}
