package Managers;

import DatabaseModels.UserModel;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static Managers.DbManager.ExecuteQuery;
import static Managers.DbManager.ExecuteUpdate;

/**
 * Created by Johan on 09/03/2016.
 */
public class UserManager implements IManager<UserModel> {
    @Override
    public List<UserModel> GetAll() throws Exception {
        List<UserModel> models = new ArrayList<>();
        ResultSet rs = ExecuteQuery("SELECT * FROM Driver");

        while (rs.next()) {
            UserModel model = new UserModel();
            model.Id = rs.getInt("Id");
            model.CalendarId = rs.getInt("CalendarId");
            model.JourneyTemplateId = rs.getInt("JourneyTemplateId");
            model.JourneyId = rs.getInt("JourneyId");
            model.CarId = rs.getInt("CarId");
            model.Firstname = rs.getString("Firstname");
            model.Lastname = rs.getString("Lastname");
            model.HomeLocation = rs.getString("HomeLocation");
            model.Promotion = rs.getString("Promotion");
            model.School = rs.getString("School");
            model.Picture = rs.getString("Picture");
            model.Sex = rs.getBoolean("Sex");
            model.IsDriver = rs.getBoolean("IsDriver");
            models.add(model);
        }

        rs.close();
        return models;
    }

    @Override
    public UserModel Get(String id) throws Exception {
        UserModel model = new UserModel();
        ResultSet rs = ExecuteQuery("SELECT * FROM Driver WHERE Id = " + id + ";");

        while (rs.next()) {
            model.Id = rs.getInt("Id");
            model.CalendarId = rs.getInt("CalendarId");
            model.JourneyTemplateId = rs.getInt("JourneyTemplateId");
            model.JourneyId = rs.getInt("JourneyId");
            model.CarId = rs.getInt("CarId");
            model.Picture = rs.getString("Picture");
            model.Firstname = rs.getString("Firstname");
            model.Lastname = rs.getString("Lastname");
            model.HomeLocation = rs.getString("HomeLocation");
            model.Promotion = rs.getString("Promotion");
            model.School = rs.getString("School");
            model.Sex = rs.getBoolean("Sex");
            model.IsDriver = rs.getBoolean("IsDriver");
        }
        rs.close();
        return model;
    }

    @Override
    public void Insert(UserModel model) throws Exception {
        String query = "INSERT INTO Driver (Firstname, Lastname, HomeLocation, Promotion, School, Sex, IsDriver, CalendarId, JourneyTemplateId, JourneyId, CarId, Picture) VALUES (" + model.Firstname + ", " + model.Lastname + ", " + model.HomeLocation + ", " + model.Promotion + ", "+model.School+" ," + model.Sex + ", " + model.IsDriver + ", " + model.CalendarId + ", " + model.JourneyTemplateId + ", " + model.JourneyId + ", " + model.CarId + ", "+model.Picture+");";
        int rs = ExecuteUpdate(query);
    }

    @Override
    public void Update(UserModel model) throws Exception {
        String query = "UPDATE Driver SET Firstname = " + model.Firstname + ", Lastname = " + model.Lastname + ", HomeLocation = " + model.HomeLocation + ", Promotion = " + model.Promotion + ", School = "+model.School+", Sex = " + model.Sex + ", IsDriver = " + model.IsDriver + ", CalendarId = " + model.CalendarId + ", JourneyTemplateId =  " + model.JourneyTemplateId + ", JourneyId = " + model.JourneyId + ", CarId = " + model.CarId + ", Picture = "+model.Picture+" WHERE Id = " + model.Id + ";";
        int rs = ExecuteUpdate(query);
    }

    @Override
    public void Delete(UserModel model) throws Exception {
        String query = "DELETE FROM Driver WHERE Id = " + model.Id + ";";
        int rs = ExecuteUpdate(query);
    }
}
