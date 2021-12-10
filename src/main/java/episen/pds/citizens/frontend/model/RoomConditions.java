package episen.pds.citizens.frontend.model;

import lombok.Data;

@Data
public class RoomConditions {
    int id_room;
    int luminosity;
    double temperature;
    String begin_time;
}
