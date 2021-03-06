package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.model.Equipment;

import episen.pds.citizens.frontend.model.architectureModel.Building;
import episen.pds.citizens.frontend.service.EquipmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;


@Controller
public class EquipmentController {

    private EquipmentService equipmentService = new EquipmentService();

    @GetMapping("/getIdrEquipmentRoom/{idr}")
    public String getEquipmentByRoom(@PathVariable("idr") final int idr, Model model) {
        Iterable<Map<String, String>> iterable = equipmentService.getEquipmentByRoom(idr);
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

    @GetMapping("/Chambre/Television")
    public String configManuScreen(@RequestParam("id_equipment") Integer id_equipment, @RequestParam("room") String name_room, Model model) {
        Integer id_room = equipmentService.getIdRoomByEquipment(id_equipment);
        model.addAttribute("id_equipment", id_equipment);
        model.addAttribute("id_room", id_room);
        String nameEquipment = equipmentService.NameEquipment(id_equipment);
        model.addAttribute("nameEquipment", nameEquipment);
        return "equipmentsHouse/ManuelleTelevision";
    }

    @GetMapping("/Cuisine/TableCuisson")
    public String configManuTableC(@RequestParam("id_equipment") Integer id_equipment, @RequestParam("room") String name_room, Model model) {
        Integer id_room = equipmentService.getIdRoomByEquipment(id_equipment);
        model.addAttribute("id_equipment", id_equipment);
        model.addAttribute("id_room", id_room);
        String nameEquipment = equipmentService.NameEquipment(id_equipment);
        model.addAttribute("nameEquipment", nameEquipment);
        return "equipmentsHouse/ManuelleTableCuisson";
    }

    @GetMapping("/fenetre")
    public String configManuWindows(@RequestParam("id_equipment") Integer id_equipment, @RequestParam("room") String name_room, Model model) {
        Integer id_room = equipmentService.getIdRoomByEquipment(id_equipment);
        model.addAttribute("id_equipment", id_equipment);
        model.addAttribute("id_room", id_room);
        String nameEquipment = equipmentService.NameEquipment(id_equipment);
        model.addAttribute("nameEquipment", nameEquipment);
        return "equipmentsHouse/fenetre";
    }

    @GetMapping("Cuisine/four")
    public String configManuFour(@RequestParam("id_equipment") Integer id_equipment, @RequestParam("room") String name_room, Model model) {
        Integer id_room = equipmentService.getIdRoomByEquipment(id_equipment);
        model.addAttribute("id_equipment", id_equipment);
        model.addAttribute("id_room", id_room);
        String nameEquipment = equipmentService.NameEquipment(id_equipment);
        model.addAttribute("nameEquipment", nameEquipment);
        return "equipmentsHouse/four";
    }

    @GetMapping("/Cuisine/Refrigerateur")
    public String configManuRefrigerateur(@RequestParam("id_equipment") Integer id_equipment, @RequestParam("room") String name_room, Model model) {
        Integer id_room = equipmentService.getIdRoomByEquipment(id_equipment);
        model.addAttribute("id_equipment", id_equipment);
        model.addAttribute("id_room", id_room);
        String nameEquipment = equipmentService.NameEquipment(id_equipment);
        model.addAttribute("nameEquipment", nameEquipment);
        return "equipmentsHouse/refrigerateur";
    }

    @GetMapping("/radiateur")
    public String configManuRadiateur(@RequestParam("id_equipment") Integer id_equipment, @RequestParam("room") String name_room, Model model) {
        Integer id_room = equipmentService.getIdRoomByEquipment(id_equipment);
        model.addAttribute("id_equipment", id_equipment);
        model.addAttribute("id_room", id_room);
        String nameEquipment = equipmentService.NameEquipment(id_equipment);
        model.addAttribute("nameEquipment", nameEquipment);
        return "equipmentsHouse/radiateur";
    }

    @GetMapping("/Douche/lave-vaisselle")
    public String updateEquipmentOnTime(@RequestParam("id_equipment") Integer id_equipment, @RequestParam("room") String name_room, Model model) {
        Integer id_room = equipmentService.getIdRoomByEquipment(id_equipment);
        model.addAttribute("id_equipment", id_equipment);
        model.addAttribute("id_room", id_room);
        String nameEquipment = equipmentService.NameEquipment(id_equipment);
        model.addAttribute("nameEquipment", nameEquipment);
        return "equipmentsHouse/laveVaisselleManuel";
    }

    @GetMapping("/Douche/s??chelinge")
    public String updateEquipmentOnTimes(@RequestParam("id_equipment") Integer id_equipment, @RequestParam("room") String name_room, Model model) {
        Integer id_room = equipmentService.getIdRoomByEquipment(id_equipment);
        model.addAttribute("id_equipment", id_equipment);
        model.addAttribute("id_room", id_room);
        String nameEquipment = equipmentService.NameEquipment(id_equipment);
        model.addAttribute("nameEquipment", nameEquipment);
        return "equipmentsHouse/s??che-linge";
    }


    @GetMapping("/formVaisselle")
    public String formVaiselle(@RequestParam("timebegin") String timebegin, @RequestParam("timeend") String timeend, @RequestParam("id_equipment") Integer id_equipment, @RequestParam("valueEquipment") Integer valueEquipment, @RequestParam("idr") Integer idr, @RequestParam("chooseStatut") String chooseStatut, @RequestParam("type_mode") String type_mode) {
        equipmentService.updateStatutMode(chooseStatut, type_mode, id_equipment);
        equipmentService.updateHoursBeginAndEndEquipment(timebegin, timeend, id_equipment);
        equipmentService.updateValueEquipment(valueEquipment, id_equipment);
        return "redirect:/getIdrEquipmentRoom/" + idr;
    }

    @GetMapping("/formfour")
    public String formfour(@RequestParam("chooseStatut") String chooseStatut, @RequestParam("type_mode") String type_mode, @RequestParam("id_equipment") Integer id_equipment, @RequestParam("valueEquipment") Integer valueEquipment, @RequestParam("idr") Integer idr, Model model) {
        equipmentService.updateStatutMode(chooseStatut, type_mode, id_equipment);
        equipmentService.updateValueEquipment(valueEquipment, id_equipment);
        return "redirect:/getIdrEquipmentRoom/" + idr;
    }


    @GetMapping("/form")
    public String form(@RequestParam("chooseStatut") String chooseStatut, @RequestParam("type_mode") String type_mode, @RequestParam("id_equipment") Integer id_equipment, @RequestParam("valueEquipment") Integer valueEquipment, @RequestParam("idr") Integer idr) {
        equipmentService.updateStatutMode(chooseStatut, type_mode, id_equipment);
        equipmentService.updateValueEquipment(valueEquipment, id_equipment);
        return "redirect:/getIdrEquipmentRoom/" + idr;
    }


    @GetMapping("/formTableCuisson")
    public String formTableC(@RequestParam("chooseStatut") String chooseStatut, @RequestParam("type_mode") String type_mode, @RequestParam("id_equipment") Integer id_equipment, @RequestParam("valueEquipment") Integer valueEquipment, @RequestParam("idr") Integer idr) {
        equipmentService.updateStatutMode(chooseStatut, type_mode, id_equipment);
        equipmentService.updateValueEquipment(valueEquipment, id_equipment);
        return "redirect:/getIdrEquipmentRoom/" + idr;
    }

    @GetMapping("/formFenetre")
    public String formWindows(@RequestParam("chooseStatut") String chooseStatut, @RequestParam("type_mode") String type_mode, @RequestParam("id_equipment") Integer id_equipment, @RequestParam("valueEquipment") Integer valueEquipment, @RequestParam("idr") Integer idr, Model model) {
        equipmentService.updateStatutMode(chooseStatut, type_mode, id_equipment);
        equipmentService.updateValueEquipment(valueEquipment, id_equipment);
        return "redirect:/getIdrEquipmentRoom/" + idr;
    }

    @GetMapping("/formRefrigerateur")
    public String formTableRefrigerateur(@RequestParam("chooseStatut") String chooseStatut, @RequestParam("type_mode") String type_mode, @RequestParam("id_equipment") Integer id_equipment, @RequestParam("valueEquipment") Integer valueEquipment, @RequestParam("idr") Integer idr, Model model) {
        equipmentService.updateStatutMode(chooseStatut, type_mode, id_equipment);
        equipmentService.updateValueEquipment(valueEquipment, id_equipment);
        return "redirect:/getIdrEquipmentRoom/" + idr;
    }

    @GetMapping("/formRadiateur")
    public String formTableRadiateur(@RequestParam("chooseStatut") String chooseStatut, @RequestParam("type_mode") String type_mode, @RequestParam("id_equipment") Integer id_equipment, @RequestParam("valueEquipment") Integer valueEquipment, @RequestParam("idr") Integer idr, Model model) {
        equipmentService.updateStatutMode(chooseStatut, type_mode, id_equipment);
        equipmentService.updateValueEquipment(valueEquipment, id_equipment);
        return "redirect:/getIdrEquipmentRoom/" + idr;
    }

    @GetMapping("/formAuto")
    public String formAuto(@RequestParam("type_mode") String type_mode, @RequestParam("id_equipment") Integer id_equipment, @RequestParam("id_room") Integer id_room, Model model) {
        equipmentService.updateStatutAuto(type_mode, id_equipment);
        List<Map<String, String>> iterable = (List<Map<String, String>>) equipmentService.getEquipmentByRoom(id_room);
        model.addAttribute("listEquipment", iterable);
        String nameRoom = equipmentService.getNameRoomByIdroom(id_room);
        model.addAttribute("nameRoom", nameRoom);
        model.addAttribute("id_room", id_room);
        return "equipmentsHouse/equipmentByRoom";
    }

    @GetMapping("/formForRoom")
    public String formNameByRoom(@RequestParam("building") Integer id_house, @RequestParam("floor") Integer id_floor, @RequestParam("room") Integer id_room, Model model) {
        List<Map<String, String>> iterable = (List<Map<String, String>>) equipmentService.getEquipmentByRoom(id_room);
        model.addAttribute("listEquipment", iterable);
        String nameRoom = equipmentService.getNameRoomByIdroom(id_room);
        model.addAttribute("nameRoom", nameRoom);
        model.addAttribute("id_room", id_room);
        return "equipmentsHouse/equipmentByRoom";
    }

    @GetMapping("/formUser")
    public String viewForm() {
        return "equipmentsHouse/formUser";
    }

    @PostMapping("/chooseRoom")
    public String chooseRoom(@RequestParam("email") String email, Model model) {
        Iterable<Building> listHouse = equipmentService.getBuildings(email);
        model.addAttribute("houses", listHouse);
        return "equipmentsHouse/chooseRoom";
    }

    @GetMapping("/chooseRoom2/{email}")
    public String chooseRoom2(@PathVariable("email") String email, Model model) {
        Iterable<Building> listHouse = equipmentService.getBuildings(email);
        model.addAttribute("houses", listHouse);
        return "equipmentsHouse/chooseRoom";
    }

    @PostMapping("/calendarwithtime")
    public String displayCalandarwithtime(@RequestParam("meeting_time") String meeting_time, Model model, @RequestParam("idr") int idr) {
        model.addAttribute("mytime", meeting_time);
        Iterable<Map<String, String>> iterable = equipmentService.getEquipmentByRoom(idr);
        model.addAttribute("listEquipment", iterable);
        String nameRoom = equipmentService.getNameRoomByIdroom(idr);
        model.addAttribute("nameRoom", nameRoom);
        model.addAttribute("id_room", idr);
        return "equipmentsHouse/equipmentByRoom";

    }
}
