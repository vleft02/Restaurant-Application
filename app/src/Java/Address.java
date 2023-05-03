public class Address{
    private int streetNumber;
    private String streetName;
    private int ZC;
    private String city;

    public Address(int streetNumber, String streetName, int ZC, String city){
        this.streetNumber=streetNumber;
        this.streetName= streetName;
        this.ZC= ZC;
        this.city=city;
    }
    public int getStreetNumber(){
        return this.streetNumber;
    }
    public String getStreetName(){
        return this.streetName;
    }
    public int getZipCode(){
        return this.ZC;
    }
    public String getCity(){
        return this.city;
    }
}