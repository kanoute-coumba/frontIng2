package episen.pds.citizens.frontcitizens.controller;

import episen.pds.citizens.frontcitizens.model.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import episen.pds.citizens.frontcitizens.service.TestService;

import java.util.logging.Logger;

@Controller
public class TestController {

    private TestService service = new TestService();

    @GetMapping("/")
    public String home(Model model) {
        Iterable<Test> listTest =null;
        try {
            listTest = service.getTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("tests", listTest);

        return "home";
    }
}
