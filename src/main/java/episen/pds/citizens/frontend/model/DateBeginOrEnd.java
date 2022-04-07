package episen.pds.citizens.frontend.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DateBeginOrEnd {
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    String date;

    public DateBeginOrEnd(String date) {
        this.date = date;
    }

    public DateBeginOrEnd() {
    }
    public long toLong(){
        try{
        String a = date.substring(0,3);
        int aa = Integer.parseInt(a);
        String M = date.substring(5,6);
        int MM = Integer.parseInt(M);
        String j = date.substring(8,9);
        int jj = Integer.parseInt(j);
        String H = date.substring(11,12);
        int HH = Integer.parseInt(H);
        String m = date.substring(14,15);
        int mm = Integer.parseInt(m);
        String s = date.substring(17,18);
        int ss = Integer.parseInt(s);
        LocalDateTime timestamp =  LocalDateTime.of(aa,MM,jj,HH,mm,ss);
        Timestamp t = Timestamp.valueOf(timestamp);
        return t.getTime()/1000;}
        catch (Exception e){
            return 0;
        }
    }
}
