package episen.pds.citizens.frontend.service;

import episen.pds.citizens.frontend.model.Menu;
import episen.pds.citizens.frontend.model.Test;
import episen.pds.citizens.frontend.repository.MenuProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.logging.Logger;

@Data
@Service
public class MenuService {

    @Autowired
    private MenuProxy menuProxy = new MenuProxy();
    public Menu getMenuById(int id) {
        //System.out.print(MenuProxy.getMenuById(id).getClass());
        return MenuProxy.getMenuById(id);
    }



    public Menu saveMenu(Menu menu) {
        System.out.println("fffffffffffff");
        System.out.println(menu);

        Menu savedMenu;

        // Règle de gestion : Le nom de famille doit être mis en majuscule.
        menu.setMenu_id(menu.getMenu_id());

        savedMenu = menuProxy.reserveMenu(menu);
        // System.out.println(savedTest + "hh");

//        if(test.getId() == null) {
//            // Si l'id est nul, alors c'est un nouvel employé.
//            savedTest = testProxy.createTest(test);
//        }
//        else {
//            savedTest = testProxy.updateTest(test);
//        }

        return savedMenu;
    }
}











