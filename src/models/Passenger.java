package models;

import DatabaseModels.UserModel;

import java.util.Random;

/**
 * Created by Johan on 10/03/2016.
 */
public class Passenger {
    private String Name;
    private String Picture;
    private int Order;

    public static Passenger UserModelToPassenger(UserModel model) {
        Passenger passenger = new Passenger();
        passenger.setName(model.Firstname + " " + model.Lastname);
        passenger.setOrder(new Random(42).nextInt());
        passenger.setPicture(model.Picture);
        return passenger;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public int getOrder() {
        return Order;
    }

    public void setOrder(int order) {
        Order = order;
    }
}