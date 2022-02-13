package episen.pds.citizens.frontend.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EquipmentWithConsumption {

    public int id_equipment;

    public int id_room;

    public String type;

    public String value;

    public LocalDateTime date_time;
}
