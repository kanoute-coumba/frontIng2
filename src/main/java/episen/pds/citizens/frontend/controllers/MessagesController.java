package episen.pds.citizens.frontend.controllers;


import episen.pds.citizens.frontend.model.Messages;
import episen.pds.citizens.frontend.model.Users;
import episen.pds.citizens.frontend.service.MessagesService;
import episen.pds.citizens.frontend.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.logging.Logger;


@Controller
public class MessagesController {

    MessagesService messagesService = new MessagesService();
    UsersService UsersService = new UsersService();
    private static final Logger logger = Logger.getLogger(MessagesController.class.getName());


    @GetMapping("/chat/sender={sender}/receiver={receiver}")
    public String getMessages(@PathVariable("sender") String sender, @PathVariable("receiver") String receiver, Model model) {
        Iterable<Messages> all_messages = messagesService.getMessages(sender, receiver);
        model.addAttribute("all_messages" , all_messages);
        Iterable<Users> all_users = UsersService.getUsers();
        model.addAttribute("all_users" , all_users);
        model.addAttribute("sender" , sender);
        model.addAttribute("receiver" , receiver);
        //logger.info(all_messages.toString());
        return "chat";

    }

    @GetMapping("/chat/{id}")
    public String getMessagesById(@PathVariable("id") String message_id, Model model) {
        System.out.println(message_id);
        Messages MessagesById = messagesService.getMessagesById(Integer.parseInt(message_id));
        model.addAttribute("MessagesById", MessagesById);
        return "chat1";
    }


/*
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

    @GetMapping("/cafeteria_reservation/saved")
    public String reserveMenu(Model model, @ModelAttribute Menu_reservation menu_reservation) {
        Menu_reservation Menu_reservation = menuService.getMenuReservation(1);
        model.addAttribute("menu_reservation", menu_reservation);
        return "cafeteria_reservation_saved";
    }*/

}
