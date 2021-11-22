package episen.pds.citizens.frontend.model;

public class MixEn {

    private int mix;


    private String name_building;

    public MixEn(){}

    public MixEn(int mix, String address){
        this.mix=mix;
        this.name_building=address;
    }

    public int getMix(){
        return mix;
    }
    public void setMix(int mix){
        this.mix=mix;
    }
    public String getNameBuilding(){
        return name_building;
    }
    public void setNameBuilding(String address){
        this.name_building=address;
    }
    public String toString(){
        return ""+name_building+" "+mix;
    }
}
