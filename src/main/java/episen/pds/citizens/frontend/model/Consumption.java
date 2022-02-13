package episen.pds.citizens.frontend.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Consumption {

    public int id_consumption;

    public int id_equipment;

    public String value;

    public LocalDateTime date_time;

}
