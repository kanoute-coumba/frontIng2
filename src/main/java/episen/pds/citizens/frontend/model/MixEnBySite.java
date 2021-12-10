package episen.pds.citizens.frontend.model;

public class MixEnBySite {
    private int mix;
    private String address;
    private String name_building;

    public MixEnBySite(){}

    public MixEnBySite(int mix, String address, String name_building){
        this.mix=mix;
        this.address=address;
        this.name_building=name_building;
    }

    public int getMix(){
        return mix;
    }
    public void setMix(int mix){
        this.mix=mix;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public String getName_building(){
        return name_building;
    }
    public void setName_building(String name_building){
        this.name_building=name_building;
    }
    public String toString(){
        return ""+address+" "+mix;
    }
}
