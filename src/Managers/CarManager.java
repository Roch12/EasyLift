package Managers;

import DatabaseModels.CarModel;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static Managers.DbManager.*;

/**
 * Created by Johan on 09/03/2016.
 */
public class CarManager implements IManager<CarModel> {
    @Override
    public List<CarModel> GetAll() throws Exception {
        List<CarModel> models = new ArrayList<>();
        ResultSet rs = ExecuteQuery("SELECT * FROM Car");

        while (rs.next()) {
            CarModel model = new CarModel();
            model.Brand = rs.getString("Brand");
            model.Seats = rs.getInt("Seats");
            models.add(model);
        }

        rs.close();
        return models;
    }

    @Override
    public CarModel Get(String id) throws Exception {
        CarModel model = new CarModel();
        ResultSet rs = ExecuteQuery("SELECT * FROM Car WHERE Id = " + id + ";");

        while (rs.next()) {
            model.Id = rs.getInt("Id");
            model.Brand = rs.getString("Brand");
            model.Seats = rs.getInt("Seats");
        }

        rs.close();
        return model;
    }

    @Override
    public void Insert(CarModel model) throws Exception {
        String query = "INSERT INTO Car(Brand, Seats) VALUES (" + model.Brand + ", " + model.Seats + ");";
        int rs = ExecuteUpdate(query);
    }

    @Override
    public void Update(CarModel model) throws Exception {
        String query = "UPDATE Car SET  Brand = " + model.Brand + ", Seats = " + model.Seats + " WHERE Id = " + model.Id + ";";
        int rs = ExecuteUpdate(query);
    }

    @Override
    public void Delete(CarModel model) throws Exception {
        String query = "DELETE FROM  Car WHERE Id = " + model.Id + ";";
        int rs = ExecuteUpdate(query);
    }
}
