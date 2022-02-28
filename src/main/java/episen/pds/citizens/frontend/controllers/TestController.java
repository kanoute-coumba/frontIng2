package episen.pds.citizens.frontend.controllers;


import episen.pds.citizens.frontend.model.Test;
import episen.pds.citizens.frontend.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    private final TestService testService = new TestService();


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

    @GetMapping("/sallesReunion")
    public String getsallesReunion(Model model) {
        return "salles-reunion";
    }


    @GetMapping("/cafeteria/validation")
    public String getMenuValidation(Model model) {
        return "cafeteria-validation";
    }

    /* @GetMapping("/chat")
    public String getChat(Model model) {
        return "chat";
    }
     */


    @GetMapping("/planAcces")
    public String getPlanAcces(Model model) {
        return "plan-acces";
    }

    @GetMapping("/designInterieur")
    public String getDesignInterieur(Model model) {
        return "design-interieur";
    }

    @GetMapping("/guidage")
    public String getGuidage(Model model) {
        return "guidage";
    }

}
