package models;

import DatabaseModels.UserModel;

import java.sql.SQLException;
import java.util.Random;

/**
 * Created by Johan on 10/03/2016.
 */
public class Passenger {
    public String Name;
    public String Picture;
    public int Order;

    public static Passenger UserModelToPassenger(UserModel model) {
        Passenger passenger = new Passenger();
        passenger.Name = model.Firstname + " " + model.Lastname;
        passenger.Order = new Random(42).nextInt();
        passenger.Picture = model.Picture;
        return passenger;
    }
}