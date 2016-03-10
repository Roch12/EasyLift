package models;

import DatabaseModels.CarModel;
import DatabaseModels.LoginModel;
import DatabaseModels.UserModel;

/**
 * Created by Johan on 10/03/2016.
 */
public class Driver {
    private String Pseudo;
    private String Name;
    private String School;
    private String Promotion;
    private boolean Sex;
    private String Picture;

    private Car UserCar;

    public static Driver UserModelToDriver(UserModel model, CarModel car, LoginModel login) {
        Driver driver = UserModelToDriver(model, car);
        driver.setPseudo(login.Username);
        return driver;
    }

    public static Driver UserModelToDriver(UserModel model, CarModel car) {
        Driver driver = UserModelToDriver(model);
        driver.setUserCar(new Car(car.Brand, car.Seats));
        return driver;
    }

    public static Driver UserModelToDriver(UserModel model) {
        Driver driver = new Driver();
        driver.setName(model.Firstname + " " + model.Lastname);
        driver.setPromotion(model.Promotion);
        driver.setSchool(model.School);
        driver.setPicture(model.Picture);
        driver.setSex(model.Sex);
        return driver;
    }

    public String getPseudo() {
        return Pseudo;
    }

    public void setPseudo(String pseudo) {
        Pseudo = pseudo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSchool() {
        return School;
    }

    public void setSchool(String school) {
        School = school;
    }

    public String getPromotion() {
        return Promotion;
    }

    public void setPromotion(String promotion) {
        Promotion = promotion;
    }

    public boolean isSex() {
        return Sex;
    }

    public void setSex(boolean sex) {
        Sex = sex;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public Car getUserCar() {
        return UserCar;
    }

    public void setUserCar(Car userCar) {
        UserCar = userCar;
    }
}
