package episen.pds.citizens.frontend.controllers;


import episen.pds.citizens.frontend.model.Test;
import episen.pds.citizens.frontend.service.EquipmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import episen.pds.citizens.frontend.service.TestService;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    private TestService testService = new TestService();
    private EquipmentService equipmentService = new EquipmentService();

//
//    @GetMapping("/home")
//    public String home() {
//        System.out.println("Réussir");
//        System.out.println(testService);
//
//        return "home";
//    }
//
    @GetMapping("/deleteTest/{id}")
    public ModelAndView deleteTest(@PathVariable("id") final int id) {
        testService.deleteTest(id);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/")
    public String getListTest(Model model) {
        Iterable<Test> listTest = testService.getTest();
        model.addAttribute("tests", listTest);
        return "index";
    }

    @GetMapping("/showNewTestForm")
    public String showNewTestForm(Model model) {
        Test test1 = new Test();
        model.addAttribute("test", test1);
        return "newTest";
    }

    @PostMapping("/saveTest")
    public String saveTest(Model model, @ModelAttribute Test test) {
        //ModelAttribut récupère l'objet crée
        model.addAttribute("listTest", testService.getTest());
        testService.saveTest(test);
        return "redirect:/";
        // ModelAndView("redirect:/");
    }
    @GetMapping("/authen")
    public String Authentification() {

        return "authentification";
    }

    @GetMapping("/piece")
    public String DisplayPiece(Model model) {
        //
        getDataId(1, 8);
        String equipLampe = equipmentService.equipmentLampe(1, 8);
        System.out.println(equipLampe);
        model.addAttribute("nameEquip", equipLampe);



        getDataId(1,7);
        String equipClimatisation = equipmentService.equipmentClimatisation(1, 7);
        System.out.println(equipClimatisation);
        model.addAttribute("nameEquipe", equipClimatisation);

        getDataId(1,1);
        String equipRadiateur = equipmentService.equipmentRadiateur(1,1);
        System.out.println(equipRadiateur);
        model.addAttribute("nameRadiateur", equipRadiateur);

        return "displayPiece";
    }

    private void getDataId(Integer id_room, Integer id_equipment) {

    }

    @GetMapping("/configurationAutomatique")
    public String equipAutomatic(Model model) {
        Integer id_room= 1;
        Integer id_floor= 1;
        Iterable<String> equipment = equipmentService.getListEquipment(id_room, id_floor);
        System.out.println(equipment);
        model.addAttribute("listequip", equipment);


        return "configAuto";
    }

    @GetMapping("/configurationManuel")
    public String equipManuel() {
        return "configManu";
    }

    @GetMapping("/conf")
    public String configuration() {
        return "conf";
    }

}
