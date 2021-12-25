package episen.pds.citizens.frontend.model;

import lombok.Data;

import java.util.Date;

@Data
public class Attribution {

    private int idAttribution;
    private int idBuilding;
    private Date date;
    private Double value;

}
