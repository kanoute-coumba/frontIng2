package episen.pds.citizens.frontend.model;

import lombok.Data;

@Data
public class Consumption {

    public int id_consumption;

    public int id_equipment;

    public String value;

    public long date_time;

}
