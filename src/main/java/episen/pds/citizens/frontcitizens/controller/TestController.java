package episen.pds.citizens.frontcitizens.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import episen.pds.citizens.frontcitizens.service.TestService;

@Controller
public class TestController {

    private TestService service;

    @GetMapping("/")
    public String home(Model model) {
        //Test listTest = service.getTest();
        //model.addAttribute("tests", listTest);

        return "home";
    }
}
