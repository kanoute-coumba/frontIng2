package episen.pds.citizens.frontend.model;

import lombok.Data;

import javax.swing.ImageIcon;
@Data
public class Equipment {
    private int id_equipment;
    private int id_room;
    private String type;
    private double value;
    private String statut;
    private ImageIcon icon;
    private double measure;
    private double consumption;
}
