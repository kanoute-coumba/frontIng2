package episen.pds.citizens.frontend.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Messages {

    private int message_id;
    private String message;
    private String sender;
    private String receiver;
    private long time;

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Messages() {
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getTime() {
        Timestamp ts = new Timestamp(time);
        String str = ts.toString();
        String[] date_hour = str.split(" ");
        str = date_hour[1];
        String[] hour = str.split(":");
        str= hour[0] + ":" + hour[1];
        return str;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
