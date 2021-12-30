package episen.pds.citizens.frontend.model;

import lombok.Data;

import java.util.Date;

@Data
public class Consumption {
    private int id;
    private Double value;
    private Date date_time;
    private int id_equipment;
}
