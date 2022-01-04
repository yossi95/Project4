package Project4;

import Project4.Address;

public class Property {

    private Address ad;
    private int rooms;
    private int cost;
    private int type;
    private String rent;
    private int numHome;
    private int numFloor;
    private User user;


    public Address getAd() {
        return ad;
    }


    public void setAd(Address ad) {
        this.ad = ad;
    }


    public int getRooms() {
        return rooms;
    }


    public void setRooms(int rooms) {
        this.rooms = rooms;
    }


    public int getCost() {
        return cost;
    }


    public void setCost(int cost) {
        this.cost = cost;
    }


    public int getType() {
        return type;
    }


    public void setType(int type) {
        this.type = type;
    }


    public String isRent() {
        return rent;
    }


    public void setRent(String rent) {
        this.rent = rent;
    }


    public int getNumHome() {
        return numHome;
    }


    public void setNumHome(int numHome) {
        this.numHome = numHome;
    }


    public int getNumFloor() {
        return numFloor;
    }


    public void setNumFloor(int numFloor) {
        this.numFloor = numFloor;
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }


    public Property(Address ad, int rooms, int cost, int type, String rent,
                    int numHome, int numFloor, User user) {
        this.ad = new Address(ad);
        this.rooms = rooms;
        this.cost = cost;
        this.type = type;
        this.rent = rent;
        this.numHome = numHome;
        this.numFloor = numFloor;
        this.user = user;
    }


    public String toString() {
        String proper = this.ad + "," + this.rooms + ", " + this.cost + " ," + this.type + "," + this.rent + "," + this.numHome + "," + this.numFloor + "," + this.user;
        return proper;
    }
}