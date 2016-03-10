package models;

import DatabaseModels.CarModel;
import DatabaseModels.LoginModel;
import DatabaseModels.UserModel;

/**
 * Created by Johan on 10/03/2016.
 */
public class Driver {
    public String Pseudo;
    public String Name;
    public String School;
    public String Promotion;
    public boolean Sex;
    public String Picture;

    public Car UserCar;

    public static Driver UserModelToDriver(UserModel model, CarModel car, LoginModel login) {
        Driver driver = UserModelToDriver(model, car);
        driver.Pseudo = login.Username;
        return driver;
    }

    public static Driver UserModelToDriver(UserModel model, CarModel car) {
        Driver driver = UserModelToDriver(model);
        driver.UserCar = new Car(car.Brand, car.Seats);
        return driver;
    }

    public static Driver UserModelToDriver(UserModel model) {
        Driver driver = new Driver();
        driver.Name = model.Firstname + " " + model.Lastname;
        driver.Promotion = model.Promotion;
        driver.School = model.School;
        driver.Picture = model.Picture;
        driver.Sex = model.Sex;
        return driver;
    }
}
