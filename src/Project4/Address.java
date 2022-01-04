package Project4;

public class Address {

    private String city, street;

    public Address (String city, String street){
        this.city= city;
        this.street= street;
    }

    public Address (Address ad){
        this.city= ad.city;
        this.street= ad.street;
    }

    public Address() {

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String toString(){
        String s= this.city+", "+this.street;
        return s;
    }
}
