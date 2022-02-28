package episen.pds.citizens.frontend.service;

import episen.pds.citizens.frontend.model.Messages;
import episen.pds.citizens.frontend.repository.MessagesProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class MessagesService {

    @Autowired
    private MessagesProxy messagesProxy = new MessagesProxy();
    public Messages getMessagesById(int id) {
        //System.out.print(MessagesProxy.getMessagesById(id).getClass());
        return MessagesProxy.getMessagesById(id);
    }

    public Iterable<Messages> getMessages(String sender, String receiver) {
        //System.out.print(MessagesProxy.getMessagesById(id).getClass());
        return MessagesProxy.getMessageBySenderAndReceiver(sender, receiver);
    }


    /*public Messages_reservation saveMessages(Messages_reservation messages_reservation) {
        return messagesProxy.reserveMessages(messages_reservation);
    }*/
}











