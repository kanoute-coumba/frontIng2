package episen.pds.citizens.frontend.controllers;

import episen.pds.citizens.frontend.model.Login;
import episen.pds.citizens.frontend.model.Users;
import episen.pds.citizens.frontend.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.logging.Logger;

@Controller
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class.getName());
    private final UsersService usersService = new UsersService();

    @PostMapping("/userName")
    public String getUserByUserName(@ModelAttribute Login username, Model model){
        Users users = usersService.getUsersByUserName(username.getLogin());
        logger.info(username.getLogin());
        if (users.getUser_id()==0){
            String erreur = "Erreur nom d'utilisateur incorrect";
            logger.info(erreur);
            Login username1 = new Login();
            model.addAttribute("username",username1);
            return "loginFalse";
        }
        model.addAttribute("user",users);
        if(users.getType().equals("Habitant")){
            return "homeResident";
        }
        if(users.getType().equals("Service Généraux")){
            return "homeService";
        }
        if(users.getType().equals("Employé")){
            return "homeEmployee";
        }
        if(users.getType().equals("Municipalité")){
            return "homeMunicipality";
        }
        Login username1 = new Login();
        model.addAttribute("username",username1);
        return "loginFalse";
    }

    @GetMapping("/login")
    public String Login(Model model){
        Login username = new Login();
        model.addAttribute("username",username);
        return "login";
    }
}
