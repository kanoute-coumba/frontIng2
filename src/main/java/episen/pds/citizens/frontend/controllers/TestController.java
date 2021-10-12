package episen.pds.citizens.frontend.controllers;


import model.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import service.TestService;

@Controller
public class TestController {

    private TestService testService = new TestService();


    @GetMapping("/home")
    public String home() {
        System.out.println("Réussir");
        System.out.println(testService);

        return "home";
    }

    @GetMapping("/deleteTest/{id}")
    public ModelAndView deleteTest(@PathVariable("id") final int id) {
        System.out.println(testService);
        testService.deleteTest(id);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/h")
    public String home(Model model) {
        Iterable<Test> listTest = testService.getTest();
        model.addAttribute("tests", listTest);
        Test t1 = new Test();

        model.addAttribute("test", t1);

        return "home";
    }

    @PostMapping("/saveTest")
    public String saveTest(Model model, @ModelAttribute Test test) {
        //ModelAttribut récupère l'objet crée

        model.addAttribute("t1", test);

        testService.saveTest(test);
        return "test";
        // ModelAndView("redirect:/");
    }
}
