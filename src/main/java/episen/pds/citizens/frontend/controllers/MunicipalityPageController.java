package episen.pds.citizens.frontend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class MunicipalityPageController {
    private static final Logger logger = Logger.getLogger(MunicipalityPageController.class.getName());

    @GetMapping("/Municipality")
    public String getPage(){
        return "municipalityPage";
    }

}
