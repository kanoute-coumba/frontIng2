package episen.pds.citizens.frontend.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Reservation {

    private int  reservation_id;
    private int user_id;
    private int id_space;
    private long start_time;
    private long end_time;

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId_space() {
        return id_space;
    }

    public void setId_space(int id_space) {
        this.id_space = id_space;
    }

    public long getStart_time() {
        return start_time;
    }

    public void setStart_time(long start_time) {
        this.start_time = start_time;
    }

    public long getEnd_time() {
        return end_time;
    }

    public void setEnd_time(long end_time) {
        this.end_time = end_time;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservation_id=" + reservation_id +
                ", user_id=" + user_id +
                ", id_space=" + id_space +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                '}';
    }
}
