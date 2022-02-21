package episen.pds.citizens.frontend.model;

import lombok.Data;

@Data
public class RoomConditions {
    int id_room;
    int luminosity;
    double temperature;
    String begin_time;
    String end_time;

    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public int getLuminosity() {
        return luminosity;
    }

    public void setLuminosity(int luminosity) {
        this.luminosity = luminosity;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(String begin_time) {
        this.begin_time = begin_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    @Override
    public String toString() {
        return "RoomConditions{" +
                "id_room=" + id_room +
                ", luminosity=" + luminosity +
                ", temperature=" + temperature +
                ", begin_time='" + begin_time + '\'' +
                ", end_time='" + end_time + '\'' +
                '}';
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
}
