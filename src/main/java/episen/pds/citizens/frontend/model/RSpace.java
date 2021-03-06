package episen.pds.citizens.frontend.model;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class RSpace {

    private int  reservation_id;
    private int user_id;
    private int id_space;
    private long start_time;
    private long end_time;
    private String  username;
    private int  right_layer;
    private String  type;
    private String  name_space;
    private String  type_space;
    private int  id_floor;

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


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRight_layer() {
        return right_layer;
    }

    public void setRight_layer(int right_layer) {
        this.right_layer = right_layer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName_space() {
        return name_space;
    }

    public void setName_space(String name_space) {
        this.name_space = name_space;
    }

    public String getType_space() {
        return type_space;
    }

    public void setType_space(String type_space) {
        this.type_space = type_space;
    }

    public int getId_floor() {
        return id_floor;
    }

    public void setId_floor(int id_floor) {
        this.id_floor = id_floor;
    }

    public String getStart_time() {
        System.out.print("starttime ");
        System.out.println(start_time);


        Timestamp ts = new Timestamp(start_time);

        System.out.print("ts : ");
        System.out.println(ts);

        String str = ts.toString();

        System.out.println(str);
        String[] date_hour = str.split(" ");
        str = date_hour[1];
        System.out.println("start");
        System.out.println(str);
        String[] hour = str.split(":");
        str= hour[0] + ":" + hour[1];
        return str;
    }

    public void setStart_time(long start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        Timestamp ts = new Timestamp(end_time);
        System.out.print("endtime ");
        System.out.println(end_time);
        String str = ts.toString();
        System.out.println("end");
        System.out.println(str);
        String[] date_hour = str.split(" ");
        str = date_hour[1];
        System.out.println(str);
        String[] hour = str.split(":");
        str= hour[0] + ":" + hour[1] + ":" + hour[2];
        return str;
    }

    public void setEnd_time(long end_time) {
        this.end_time = end_time;
    }


    @Override
    public String toString() {
        return "ReservesSpace{" +
                "reservation_id=" + reservation_id +
                ", user_id=" + user_id +
                ", id_space=" + id_space +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", username='" + username + '\'' +
                ", right_layer=" + right_layer +
                ", type='" + type + '\'' +
                ", name_space='" + name_space + '\'' +
                ", type_space='" + type_space + '\'' +
                ", id_floor=" + id_floor +
                '}';
    }
}
