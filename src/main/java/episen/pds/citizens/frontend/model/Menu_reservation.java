package episen.pds.citizens.frontend.model;

import lombok.Data;

@Data
public class Menu_reservation {

    private int reservation_id;
    private String name;
    private int menu_number;
    private String time_slot;
    private String note;

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMenu_number() {
        return menu_number;
    }

    public void setMenu_number(int menu_number) {
        this.menu_number = menu_number;
    }

    public String getTime_slot() {
        return time_slot;
    }

    public void setTime_slot(String time_slot) {
        this.time_slot = time_slot;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Menu_reservation{" +
                "reservation_id=" + reservation_id +
                ", name='" + name + '\'' +
                ", menu_number=" + menu_number +
                ", time_slot=" + time_slot +
                ", note='" + note + '\'' +
                '}';
    }
}

