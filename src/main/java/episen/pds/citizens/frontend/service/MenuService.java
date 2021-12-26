package episen.pds.citizens.frontend.service;

import episen.pds.citizens.frontend.model.Menu;
import episen.pds.citizens.frontend.model.Menu_reservation;
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

    public Menu_reservation getMenuReservation(int id) {
        //System.out.print(MenuProxy.getMenuById(id).getClass());
        return MenuProxy.getMenuReservation(id);
    }

    public Menu_reservation saveMenu(Menu_reservation menu_reservation) {
        return menuProxy.reserveMenu(menu_reservation);
    }
}











