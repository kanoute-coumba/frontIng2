package episen.pds.citizens.frontend.model;

import lombok.Data;

import javax.swing.ImageIcon;
@Data
public class Equipment {
    private int Id;
    private String type;
    private double value;
    private String status;
    private ImageIcon icon;
    private double measure;
    private double consumption;
}
