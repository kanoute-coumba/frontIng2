package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.model.Equipment;
import episen.pds.citizens.frontend.service.EquipmentService;
import episen.pds.citizens.frontend.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EquipmentController {

    private EquipmentService equipmentService = new EquipmentService();

    @GetMapping("/getIdrEquipmentRoom/{idr}")
    public String getEquipmentByRoom(@PathVariable("idr") final int idr, Model model) {
        List<Equipment> iterable = (List<Equipment>) equipmentService.getEquipmentByRoom(idr);
        model.addAttribute("listEquipment", iterable);
        String nameRoom = equipmentService.getNameRoomByIdroom(idr);
        model.addAttribute("nameRoom", nameRoom);
        model.addAttribute("id_room", idr);
        System.out.println(idr);
        return "equipmentByRoom";
    }


    @GetMapping("/configurationLampe")
    public String displayConfigLampe(@RequestParam("id_equipment") Integer id_equipment, @RequestParam("room") String name_room, Model model) {
        System.out.println(name_room);
        System.out.println(id_equipment + " valeur ");
        model.addAttribute("id_equipment", id_equipment);
        model.addAttribute("nameRoom", name_room);
        String nameEquipment = equipmentService.NameEquipment(id_equipment);
        model.addAttribute("nameEquipment", nameEquipment);
        System.out.println(nameEquipment + "nananananan");
        return "configurationLampe";
    }

    @GetMapping("/Chambre/Lampe")
    public String configManuel(@RequestParam("id_equipment") Integer id_equipment, @RequestParam("room") String name_room, Model model) {
        Integer id_room = equipmentService.getIdRoomByEquipment(id_equipment);
        model.addAttribute("id_equipment", id_equipment);
        model.addAttribute("id_room", id_room);
        String nameEquipment = equipmentService.NameEquipment(id_equipment);
        model.addAttribute("nameEquipment", nameEquipment);
        return "Manuelle";
    }

    @GetMapping("/form")
    public String form(@RequestParam("chooseStatut") String chooseStatut, @RequestParam("type_mode") String type_mode, @RequestParam("id_equipment") Integer id_equipment, @RequestParam("valueEquipment") Integer valueEquipment, @RequestParam("idr") Integer idr, Model model) {
        equipmentService.updateStatutMode(chooseStatut, type_mode, id_equipment);
        equipmentService.updateValueEquipment(valueEquipment, id_equipment);
        System.out.println(id_equipment);
        System.out.println("ICI EST L'iDDD : " + idr);
        return "redirect:/getIdrEquipmentRoom/" +idr ;
    }

    @GetMapping("/formForRoom")
    public String formNameByRoom(@RequestParam("room") String room, @RequestParam("floor") Integer floor, Model model) {
        Integer id_room = equipmentService.retriveIdroom(room, floor);
        List<Equipment> iterable = (List<Equipment>) equipmentService.getEquipmentByRoom(id_room);
        System.out.println(id_room + "vvvvvvv");
        model.addAttribute("listEquipment", iterable);
        String nameRoom = equipmentService.getNameRoomByIdroom(id_room);
        model.addAttribute("nameRoom", nameRoom);
        System.out.println(id_room);
        return "equipmentByRoom";
    }

    @GetMapping("/roomByFloor")
    public String NameRoomByFloor(Integer id_floor, Model model) {
        System.out.println("controler début");
        Iterable<String> listRoomByFloor = equipmentService.NameRoomByFloor(id_floor);
        model.addAttribute("listRoom", listRoomByFloor);
        model.addAttribute("id_floor", id_floor);
        System.out.println("controler fin");
        return "listRoomByFloor";
    }

    @GetMapping("/formForFloor")
    public String formNameByFloor(@RequestParam("floor") String name_floor, @RequestParam("building") Integer id_building, Model model) {
        Integer id_floor = equipmentService.retriveIdFloor(name_floor, id_building);

        Iterable<String> listRoomByFloor = equipmentService.NameRoomByFloor(id_floor);
        model.addAttribute("listRoom", listRoomByFloor);
        model.addAttribute("id_floor", id_floor);
        System.out.println("controler fin");
        return "listRoomByFloor";


    }

    @GetMapping("/floorByBuilding")
    public String NameFloorByBuilding(Integer id_building, Model model) {
        Iterable<String> listFloorByBuilding = equipmentService.NameFloorByBuilding(id_building);
        model.addAttribute("listFloor", listFloorByBuilding);
        model.addAttribute("id_building", id_building);
        return "listFloorByBuilding";
    }


}
