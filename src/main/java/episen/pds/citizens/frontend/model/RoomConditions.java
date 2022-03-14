package episen.pds.citizens.frontend.model;

import lombok.Data;
import org.apache.tomcat.jni.Local;

import java.time.LocalTime;

@Data
public class RoomConditions {
    int id_room;
    int luminosity;
    double temperature;
    LocalTime begin_time;
    LocalTime end_time;

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

    public LocalTime getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(LocalTime begin_time) {
        this.begin_time = begin_time;
    }

    public LocalTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalTime end_time) {
        this.end_time = end_time;
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
}
