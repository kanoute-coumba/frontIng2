package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.model.BuildingCentral;
import episen.pds.citizens.frontend.model.District;
import episen.pds.citizens.frontend.service.BuildingCentralService;
import episen.pds.citizens.frontend.service.DistrictService;
import episen.pds.citizens.frontend.service.SmartGridService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private BuildingCentralService buildingCentralService;

    @Autowired
    private SmartGridService smartGridService;

    @Autowired
    private SimpMessagingTemplate template;

    @Scheduled(cron = "*/30 * * * * *")
    public void loop() {
//        System.out.println("central updated");
//        List<District> districts = districtService.readDistricts();
//        this.template.convertAndSend("/smartgrid/districts", districts);
//        List<BuildingCentral> centrals = buildingCentralService.readBuildingsTypeCentral();
//        this.template.convertAndSend("/smartgrid/centrals", centrals);
//        Double balance = smartGridService.smartgrid();
//        this.template.convertAndSend("/smartgrid/balance", balance);
    }

    @GetMapping("/smartgrid")
    public String init(Model model) {
        List<District> districts = districtService.readDistricts();
        model.addAttribute("districts", districts);
        List<BuildingCentral> centrals = buildingCentralService.readBuildingsTypeCentral();
        model.addAttribute("centrals", centrals);
        Double balance = smartGridService.smartgrid();
        model.addAttribute("balance", balance);
        return "smartgrid.html";
    }

    /*@MessageMapping("/refresh")
    @SendTo("/smartgrid/refresh")
    public Boolean refresh(String message) {
        message = message.replace("\"", "");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return message.equals("refresh");
    }*/
}
