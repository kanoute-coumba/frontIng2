package episen.pds.citizens.frontend.model;

import lombok.Data;

@Data
public class Users {

    private int user_id;
    private String username;
    private String right_layer;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRight_layer() {
        return right_layer;
    }

    public void setRight_layer(String right_layer) {
        this.right_layer = right_layer;
    }
}
