package episen.pds.citizens.frontend.controllers;


import episen.pds.citizens.frontend.model.Menu;
import episen.pds.citizens.frontend.model.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import episen.pds.citizens.frontend.service.MenuService;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class MenuController {

    MenuService menuService = new MenuService();


    @GetMapping("/cafeteria")
    public String getMenuById(Model model) {
        int i = 1;
        while (i < 4) {
            Menu menu = menuService.getMenuById(i);
            model.addAttribute("Menu"+i , menu);
            i++;
        }
        return "cafeteria";

    }

//    @GetMapping("/cafeteria_reservation")
  //  public String savecMenu(Model model, @ModelAttribute Menu menu) {
        //ModelAttribut récupère l'objet crée
        //model.addAttribute("reserved-menu", menuService.getMenuById(1));
        //menuService.saveMenu(menu);
   //     return "cafeteria_reservation";
 //   }

    @GetMapping("/cafeteria_reservation")
    public String reserveMenu(Model model, @ModelAttribute Menu menu) {
        return "cafeteria_reservation";
    }

}
