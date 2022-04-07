package episen.pds.citizens.frontend.model;

import lombok.Data;

@Data
public class Users {

    private int user_id;
    private String username;
    private int right_layer;
    private String type;

    public void setType(String type) {
        this.type = type;
    }

    public Users(int user_id, String username, int right_layer,String type) {
        this.user_id = user_id;
        this.username = username;
        this.right_layer = right_layer;
        this.type=type;
    }

    public Users() {
    }

    public int getUser_id() {
        return user_id;
    }

    public String getType(){return type;}

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
}
