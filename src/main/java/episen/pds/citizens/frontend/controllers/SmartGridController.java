package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.model.District;
import episen.pds.citizens.frontend.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@EnableScheduling
public class SmartGridController {

    @Autowired
    private DistrictService districtService;

    @Autowired
    private SimpMessagingTemplate template;

    @Scheduled(cron = "*/5 * * * * *")
    public void loop() {
        System.out.println("OK");
        List<District> districts = districtService.readDistricts();
        this.template.convertAndSend("/smartgrid/districts", districts);
    }

    @GetMapping("/smartgrid")
    public String getBuildings(Model model) {
        List<District> districts = districtService.readDistricts();
        model.addAttribute("districts", districts);
        return "smartgrid.html";
    }

    @MessageMapping("/refresh")
    @SendTo("/smartgrid/refresh")
    public Boolean refresh(String message) {
        message = message.replace("\"", "");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return message.equals("refresh");
    }
}
