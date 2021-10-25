package episen.pds.citizens.frontend.controllers;


import episen.pds.citizens.frontend.model.Test;
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
        System.out.println(testService);
        testService.deleteTest(id);
        return new ModelAndView("redirect:/h");
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
        System.out.println(test);
        //ModelAttribut récupère l'objet crée
        model.addAttribute("listTest", testService.getTest());
        testService.saveTest(test);
        return "redirect:/h";
        // ModelAndView("redirect:/");
    }


}
