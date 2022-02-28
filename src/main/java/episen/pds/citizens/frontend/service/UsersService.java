package episen.pds.citizens.frontend.service;

import episen.pds.citizens.frontend.model.Users;
import episen.pds.citizens.frontend.repository.UsersProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class UsersService {

    @Autowired
    private UsersProxy usersProxy = new UsersProxy();

    public Iterable<Users> getUsers() {
        return usersProxy.getUsers();
    }

    /*public Messages_reservation saveMessages(Messages_reservation messages_reservation) {
        return messagesProxy.reserveMessages(messages_reservation);
    }*/
}











