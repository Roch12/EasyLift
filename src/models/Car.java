package models;

/**
 * Created by Johan on 10/03/2016.
 */
public class Car {
    private String Brand;
    private int Seats;

    public Car(String brand, int seats ) {
        setBrand(brand);
        setSeats(seats);
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public int getSeats() {
        return Seats;
    }

    public void setSeats(int seats) {
        Seats = seats;
    }
}
