package episen.pds.citizens.frontend.service;

import episen.pds.citizens.frontend.model.Users;
import episen.pds.citizens.frontend.repository.UsersProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.logging.Logger;

@Data
@Service
public class UsersService {

    private UsersProxy usersProxy = new UsersProxy();
    private static final Logger logger = Logger.getLogger(UsersService.class.getName());

    public Iterable<Users> getUsers() {
        return usersProxy.getUsers();
    }

    /*public Messages_reservation saveMessages(Messages_reservation messages_reservation) {
        return messagesProxy.reserveMessages(messages_reservation);
    }*/
    public Users getUsersByUserName(String uName){
        logger.info("dans le service getUsersByUserName");
        ArrayList<Users> arrayList = usersProxy.getUsersByUserName(uName);
        if(arrayList.size()==1){
            logger.info("1 user");
            return arrayList.get(0);
        }
        else {
            return new Users(0,"vide",1,"vide");
        }
    }
}











