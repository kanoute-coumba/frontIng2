package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.CustomProperties;
import episen.pds.citizens.frontend.model.District;
import episen.pds.citizens.frontend.service.BuildingServicePatch;
import episen.pds.citizens.frontend.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

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

    //----------------------------------------------------------------------------

    @MessageMapping("/hello")//-> from client we send on '/smartgrid/hello'
    @SendTo("/smartgrid/hello")//-> from client we receive on '/topic/hello'
    public String hello(HelloMessage message) {
        System.out.println(message.getName());
        return "Hello, from server. NAME : " + message.getName();
    }

    public class HelloMessage {

        private String name;

        public HelloMessage() {
        }

        public HelloMessage(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
