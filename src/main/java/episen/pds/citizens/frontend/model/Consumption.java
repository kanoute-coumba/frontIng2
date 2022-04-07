package episen.pds.citizens.frontend.model;

import lombok.Data;

import java.util.Date;

@Data
public class Consumption {
    private int id_consumption;
    private Double value;
    private int date_time;
    private int id_equipment;
}
