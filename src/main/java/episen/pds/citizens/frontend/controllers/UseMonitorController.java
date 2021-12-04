package episen.pds.citizens.frontend.controllers;
import episen.pds.citizens.frontend.model.RoomConditions;
import episen.pds.citizens.frontend.model.Equipment;
import episen.pds.citizens.frontend.model.RoomsWithConsumption;
import episen.pds.citizens.frontend.service.UseMonitorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UseMonitorController {
    private UseMonitorService useMonitorService = new UseMonitorService();

    @GetMapping("/configManual")
    @ResponseBody
    public String getRoomConditions(Model model, @RequestParam int id) {
        Iterable<RoomConditions> listConditions = useMonitorService.getConditionsInRoom(id);
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

    @GetMapping("/configManual")
    @ResponseBody
    public  String getEquipmentByRoom(Model model, @RequestParam int id) {
        Iterable<Equipment> listEquipmentInRoom = useMonitorService.getEquipmentByRoom(id);
        model.addAttribute("equipments", listEquipmentInRoom);
        return "configmanu";
    }
}
