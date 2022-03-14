package episen.pds.citizens.frontend.controllers;


import episen.pds.citizens.frontend.model.Menu;
import episen.pds.citizens.frontend.model.Menu_reservation;
import episen.pds.citizens.frontend.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.logging.Logger;


@Controller
public class MenuController {

    MenuService menuService = new MenuService();
    private static final Logger logger = Logger.getLogger(MenuController.class.getName());


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
    @GetMapping("/cafeteria_reservation/{num_menu}")
    public String reserveMenu(@PathVariable("num_menu") String num_menu, Model model) {
        System.out.println(num_menu);
        Menu_reservation menu_reservation = new Menu_reservation();
        model.addAttribute("menu_reservation", menu_reservation);
        model.addAttribute("num_menu", num_menu);
        return "cafeteria_reservation";
    }



    @PostMapping("/cafeteria_reservation/saved")
    public String formReservation(Model model, @ModelAttribute Menu_reservation menu_reservation) {
        //ModelAttribut récupère l'objet crée
        model.addAttribute("menu_reservation", menu_reservation);
        return "cafeteria_reservation_saved";
    }

    @PostMapping("/cafeteria_reservation/saved/confirm")
    public String saveReservation (Model model, @ModelAttribute("menu_reservation") Menu_reservation menu_reservation) {
        logger.info(menu_reservation.toString());
        menuService.saveMenu(menu_reservation);
        return "redirect:/cafeteria";
    }

    /*@GetMapping("/cafeteria_reservation/saved")
    public String reserveMenu(Model model, @ModelAttribute Menu_reservation menu_reservation) {
        Menu_reservation Menu_reservation = menuService.getMenuReservation(1);
        model.addAttribute("menu_reservation", menu_reservation);
        return "cafeteria_reservation_saved";
    }*/

}
