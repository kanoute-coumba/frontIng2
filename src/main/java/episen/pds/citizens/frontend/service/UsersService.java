package episen.pds.citizens.frontend.service;

import episen.pds.citizens.frontend.model.Users;
import episen.pds.citizens.frontend.repository.UsersProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Data
@Service
public class UsersService {

    private UsersProxy usersProxy = new UsersProxy();

    public Iterable<Users> getUsers() {
        return usersProxy.getUsers();
    }

    /*public Messages_reservation saveMessages(Messages_reservation messages_reservation) {
        return messagesProxy.reserveMessages(messages_reservation);
    }*/
    public Users getUsersByUserName(String uName){
        ArrayList<Users> arrayList = usersProxy.getUsersByUserName(uName);
        if(arrayList.size()==1){
            return arrayList.get(0);
        }
        else {
            return new Users(0,"vide","vide","vide");
        }
    }
}











