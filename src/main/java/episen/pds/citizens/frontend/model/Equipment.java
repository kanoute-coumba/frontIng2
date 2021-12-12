package episen.pds.citizens.frontend.model;

import lombok.Data;

import javax.swing.ImageIcon;
@Data
public class Equipment {
    private int id_equipment;
    private int id_room;
    private String type;
    private double value;
    private String type_mode;
    private String statut;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getId_equipment() {
        return id_equipment;
    }

    public void setId_equipment(int id_equipment) {
        this.id_equipment = id_equipment;
    }

    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getType_mode() {
        return type_mode;
    }

    public void setType_mode(String type_mode) {
        this.type_mode = type_mode;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id_equipment=" + id_equipment +
                ", id_room=" + id_room +
                ", type='" + type + '\'' +
                ", value=" + value +
                ", type_mode='" + type_mode + '\'' +
                ", statut='" + statut + '\'' +
                '}';
    }
}
