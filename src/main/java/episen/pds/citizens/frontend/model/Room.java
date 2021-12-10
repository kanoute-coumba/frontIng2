package episen.pds.citizens.frontend.model;

public class Room {
    private int id_room;
    private int id_floor;
    private String name;

    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public int getId_floor() {
        return id_floor;
    }

    public void setId_floor(int id_floor) {
        this.id_floor = id_floor;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id_room=" + id_room +
                ", id_floor=" + id_floor +
                ", name='" + name +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}
