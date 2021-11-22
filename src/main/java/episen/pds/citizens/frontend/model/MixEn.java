package episen.pds.citizens.frontend.model;

public class MixEn {

    private int mix;


    private String address;

    public MixEn(){}

    public MixEn(int mix, String address){
        this.mix=mix;
        this.address=address;
    }

    public int getMix(){
        return mix;
    }
    public void setMix(int mix){
        this.mix=mix;
    }
    public String getAdress(){
        return address;
    }
    public void setAdress(String address){
        this.address=address;
    }
    public String toString(){
        return ""+address+" "+mix;
    }
}
