package episen.pds.citizens.frontend.service;

import episen.pds.citizens.frontend.model.RSpace;
import episen.pds.citizens.frontend.model.Reservation;
import episen.pds.citizens.frontend.model.architectureModel.Space;
import episen.pds.citizens.frontend.repository.MessagesProxy;
import episen.pds.citizens.frontend.repository.ReservationProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class ReservationService {

    @Autowired
    private ReservationProxy reservationProxy = new ReservationProxy();
    public Reservation getReservationById(int id) {
        //System.out.print(MessagesProxy.getMessagesById(id).getClass());
        return reservationProxy.getReservationById(id);
    }

    public Iterable<Reservation> getReservation() {
        //System.out.print(MessagesProxy.getMessagesById(id).getClass());
        return reservationProxy.getReservation();
    }

    public Iterable<RSpace> getReservesSpace() {
        //System.out.print(MessagesProxy.getMessagesById(id).getClass());
        return reservationProxy.getReservedSpace();
    }



    /*public Messages_reservation saveMessages(Messages_reservation messages_reservation) {
        return messagesProxy.reserveMessages(messages_reservation);
    }*/
}











