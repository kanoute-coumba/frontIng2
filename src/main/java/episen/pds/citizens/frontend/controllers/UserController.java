package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.model.Consumption;
import episen.pds.citizens.frontend.model.Login;
import episen.pds.citizens.frontend.model.Production;
import episen.pds.citizens.frontend.model.Users;
import episen.pds.citizens.frontend.model.architectureModel.Building;
import episen.pds.citizens.frontend.service.ConsumptionService;
import episen.pds.citizens.frontend.service.EnergyService;
import episen.pds.citizens.frontend.service.UsersService;
import episen.pds.citizens.frontend.service.architectureService.BuildingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.logging.Logger;

@Controller
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class.getName());
    private final UsersService usersService = new UsersService();
    private final BuildingService buildingService = new BuildingService();
    private final ConsumptionService consumptionService = new ConsumptionService();
    private final EnergyService energyService = new EnergyService();

    @PostMapping("/userName")
    public String getUserByUserName(@ModelAttribute Login username, Model model){
        Users users = usersService.getUsersByUserName(username.getLogin());
        logger.info(username.getLogin());
        if (users.getUser_id() == 0){
            String erreur = "Erreur nom d'utilisateur incorrect";
            logger.info(erreur);
            Login username1 = new Login();
            model.addAttribute("username",username1);
            return "loginFalse";
        }
        model.addAttribute("user",users);
        if(users.getType().equals("Habitant")){
            ArrayList<Building> buildingIterable = buildingService.getBuildingByIdUser(users.getUser_id());
            if(buildingIterable.size()==1){
                Building b = buildingIterable.get(0);
                model.addAttribute("house",b);
                logger.info(b+"");
            }
            else{
                model.addAttribute("buildingIterable",buildingIterable);}
            return "homeResident";
        }
        if(users.getType().equals("Service G??n??raux")){
            return "homeService";
        }
        if(users.getType().equals("Employ??")){
            return "homeEmployee";
        }
        if(users.getType().equals("Municipalit??")){
            return "redirect:/smartgrid";
        }
        Login username1 = new Login();
        model.addAttribute("username",username1);
        return "loginFalse";
    }

    @GetMapping("/home")
    public String getUserByUserName(@RequestParam("username") String username, Model model){
        Users users = usersService.getUsersByUserName(username);
        logger.info(username);
        if (users.getUser_id() == 0){
            String erreur = "Erreur nom d'utilisateur incorrect";
            logger.info(erreur);
            Login username1 = new Login();
            model.addAttribute("username",username1);
            return "loginFalse";
        }
        model.addAttribute("user",users);
        if(users.getType().equals("Habitant")){
            ArrayList<Building> buildingIterable = buildingService.getBuildingByIdUser(users.getUser_id());
            if(buildingIterable.size()==1){
                Building b = buildingIterable.get(0);
                model.addAttribute("house",b);
                Consumption consumption = consumptionService.getConsumptionByIdBuilding(b.getId_building());
                Production production = energyService.getProductionByIdBuilding(b.getId_building());
                model.addAttribute("production", production);
                model.addAttribute("consumption",consumption);
                model.addAttribute("diff",production.getValue()-consumption.getValue());
                logger.info(b+"");
            }
            else{
                model.addAttribute("buildingIterable",buildingIterable);}
            return "homeResident";
        }
        if(users.getType().equals("Service G??n??raux")){
            return "homeService";
        }
        if(users.getType().equals("Employ??")){
            return "homeEmployee";
        }
        if(users.getType().equals("Municipalit??")){
            return "redirect:/smartgrid";
        }
        Login username1 = new Login();
        model.addAttribute("username",username1);
        return "loginFalse";
    }

    @GetMapping("/login")
    public String Login(Model model){
        Login username = new Login();
        model.addAttribute("username", username);
        logger.info("login d'un utilisateur");
        return "login";
    }
}
