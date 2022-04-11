package episen.pds.citizens.frontend.controllers;


import episen.pds.citizens.frontend.model.Reservation;
import episen.pds.citizens.frontend.model.architectureModel.Space;
import episen.pds.citizens.frontend.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.logging.Logger;


@Controller
public class ReservationController {

    ReservationService reservationService = new ReservationService();
    private static final Logger logger = Logger.getLogger(ReservationController.class.getName());



    @GetMapping("/reservations/{id}")
    public String getReservationById(@PathVariable("id") String message_id, Model model) {
        System.out.println(message_id);
        Reservation ReservationById = reservationService.getReservationById(Integer.parseInt(message_id));
        model.addAttribute("ReservationById", ReservationById);
        return "spaceReservation";
    }

    @GetMapping("/reservations")
    public String getReservation(Model model) {
        Iterable<Reservation> listReservation = reservationService.getReservation();
        model.addAttribute("Reservation", listReservation);

        Iterable<Space> listReservedSpace = reservationService.getReservesSpace();
        model.addAttribute("ReservedSpace", listReservedSpace);

        return "spaceReservation";
    }



}
