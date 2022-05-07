package episen.pds.citizens.frontend.model;

import episen.pds.citizens.frontend.controllers.ConsumptionController;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.logging.Logger;

public class DateBeginOrEnd {
    private static final Logger logger = Logger.getLogger(DateBeginOrEnd.class.getName());
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

    @Override
    public String toString() {
        return "AAAA/MM/JJ/HH/mm/ss";
    }

    public long toLong(){
        logger.info("la date est "+date);
        try{
        String a = date.substring(0,4);
        int aa = Integer.parseInt(a);
        String M = date.substring(5,7);
        int MM = Integer.parseInt(M);
        String j = date.substring(8,10);
        int jj = Integer.parseInt(j);
        String H = date.substring(11,13);
        int HH = Integer.parseInt(H);
        String m = date.substring(14,16);
        int mm = Integer.parseInt(m);
        String s = date.substring(17,19);
        int ss = Integer.parseInt(s);
        LocalDateTime timestamp =  LocalDateTime.of(aa,MM,jj,HH,mm,ss);
        Timestamp t = Timestamp.valueOf(timestamp);
        logger.info(t.getTime()/1000+"");
        return t.getTime()/1000;}
        catch (Exception e){
            return 0;
        }
    }
}
