package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.model.Equipment;
import episen.pds.citizens.frontend.model.House;
import episen.pds.citizens.frontend.service.EquipmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

        return "equipmentsHouse/equipmentByRoom";
    }


    @GetMapping("/configurationLampe")
    public String displayConfigLampe(@RequestParam("id_equipment") Integer id_equipment, @RequestParam("room") String name_room, Model model) {

        model.addAttribute("id_equipment", id_equipment);
        model.addAttribute("nameRoom", name_room);
        String nameEquipment = equipmentService.NameEquipment(id_equipment);
        model.addAttribute("nameEquipment", nameEquipment);

        return "equipmentsHouse/configurationLampe";
    }

    @GetMapping("/Chambre/Lampe")
    public String configManuel(@RequestParam("id_equipment") Integer id_equipment, @RequestParam("room") String name_room, Model model) {
        Integer id_room = equipmentService.getIdRoomByEquipment(id_equipment);
        model.addAttribute("id_equipment", id_equipment);
        model.addAttribute("id_room", id_room);
        String nameEquipment = equipmentService.NameEquipment(id_equipment);
        model.addAttribute("nameEquipment", nameEquipment);
        return "equipmentsHouse/Manuelle";
    }

    @GetMapping("/Chambre/Télévision")
    public String configManuScreen(@RequestParam("id_equipment") Integer id_equipment, @RequestParam("room") String name_room, Model model) {
        Integer id_room = equipmentService.getIdRoomByEquipment(id_equipment);
        model.addAttribute("id_equipment", id_equipment);
        model.addAttribute("id_room", id_room);
        String nameEquipment = equipmentService.NameEquipment(id_equipment);
        model.addAttribute("nameEquipment", nameEquipment);
        return "equipmentsHouse/ManuelleTélévision";
    }


    @GetMapping("/form")
    public String form(@RequestParam("chooseStatut") String chooseStatut, @RequestParam("type_mode") String type_mode, @RequestParam("id_equipment") Integer id_equipment, @RequestParam("valueEquipment") Integer valueEquipment, @RequestParam("idr") Integer idr, Model model) {
        equipmentService.updateStatutMode(chooseStatut, type_mode, id_equipment);
        equipmentService.updateValueEquipment(valueEquipment, id_equipment);

        return "redirect:/getIdrEquipmentRoom/" + idr;
    }

    @GetMapping("/formAuto")
    public String formAuto(@RequestParam("type_mode") String type_mode, @RequestParam("id_equipment") Integer id_equipment) {
        equipmentService.updateStatutAuto(type_mode, id_equipment);

        return "equipmentsHouse/response";
    }

    @GetMapping("/formForRoom")
    public String formNameByRoom(@RequestParam("house") Integer id_house, @RequestParam("floor") Integer id_floor, @RequestParam("room") Integer id_room, Model model) {
        List<Equipment> iterable = (List<Equipment>) equipmentService.getEquipmentByRoom(id_room);

        model.addAttribute("listEquipment", iterable);
        String nameRoom = equipmentService.getNameRoomByIdroom(id_room);
        model.addAttribute("nameRoom", nameRoom);

        return "equipmentsHouse/equipmentByRoom";
    }

    @GetMapping("/formUser")
    public String viewForm() {
        return "equipmentsHouse/formUser";
    }

    @PostMapping("/chooseRoom")
    public String chooseRoom(@RequestParam("email") String email, Model model) {
        Iterable<House> listHouse = equipmentService.getBuildings(email);
        model.addAttribute("houses", listHouse);
        return "equipmentsHouse/chooseRoom";
    }




}
