package models;

import java.util.Date;

/**
 * Created by Maxime on 04/03/2016.
 */
public class Tile {
    private int Id;
    private String Username;
    private String FirstName;
    private String LastName;
    private Date DateStart;
    private int PlaceAvailable;
    private int PlaceMaximum;
    private String StartLocation;
    private String Promo;

    public Tile(int id, String username, String firstName, String lastName, Date dateStart, int placeAvailable, int placeMaximum, String startLocation, String promo) {
        Id = id;
        Username = username;
        FirstName = firstName;
        LastName = lastName;
        DateStart = dateStart;
        PlaceAvailable = placeAvailable;
        PlaceMaximum = placeMaximum;
        StartLocation = startLocation;
        Promo = promo;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Date getDateStart() {
        return DateStart;
    }

    public void setDateStart(Date dateStart) {
        DateStart = dateStart;
    }

    public int getPlaceAvailable() {
        return PlaceAvailable;
    }

    public void setPlaceAvailable(int placeAvailable) {
        PlaceAvailable = placeAvailable;
    }

    public int getPlaceMaximum() {
        return PlaceMaximum;
    }

    public void setPlaceMaximum(int placeMaximum) {
        PlaceMaximum = placeMaximum;
    }

    public String getStartLocation() {
        return StartLocation;
    }

    public void setStartLocation(String startLocation) {
        StartLocation = startLocation;
    }

    public String getPromo() {
        return Promo;
    }

    public void setPromo(String promo) {
        Promo = promo;
    }
}
