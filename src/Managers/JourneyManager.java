package Managers;

import DatabaseModels.JourneyModel;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static Managers.DbManager.ExecuteQuery;
import static Managers.DbManager.ExecuteUpdate;

/**
 * Created by Johan on 09/03/2016.
 */
public class JourneyManager implements IManager<JourneyModel> {
    @Override
    public List<JourneyModel> GetAll() throws Exception {
        List<JourneyModel> models = new ArrayList<>();
        ResultSet rs = ExecuteQuery("SELECT * FROM Journey;");
        while (rs.next()) {
            JourneyModel model = new JourneyModel();
            model.Id = rs.getInt("Id");
            model.CarId = rs.getInt("CarId");
            model.JourneyId = rs.getInt("JourneyId");
            model.UserId = rs.getInt("UserId");
            model.IsDriver = rs.getBoolean("IsDriver");
            models.add(model);
        }
        rs.close();
        return models;
    }

    @Override
    public JourneyModel Get(String id) throws Exception {
        JourneyModel model = new JourneyModel();
        ResultSet rs = ExecuteQuery("SELECT * FROM Journey WHERE Id =" + id + ";");

        while (rs.next()) {
            model.Id = rs.getInt("Id");
            model.CarId = rs.getInt("CarId");
            model.JourneyId = rs.getInt("JourneyId");
            model.UserId = rs.getInt("UserId");
            model.IsDriver = rs.getBoolean("IsDriver");
        }
        rs.close();
        return model;
    }

    public JourneyModel GetFromTemplate(String journeyTemplateId) throws Exception {
        JourneyModel model = new JourneyModel();
        ResultSet rs = ExecuteQuery("SELECT * FROM Journey WHERE JourneyId =" + journeyTemplateId + ";");

        while (rs.next()) {
            model.Id = rs.getInt("Id");
            model.CarId = rs.getInt("CarId");
            model.JourneyId = rs.getInt("JourneyId");
            model.UserId = rs.getInt("UserId");
            model.IsDriver = rs.getBoolean("IsDriver");
        }
        rs.close();
        return model;
    }

    @Override
    public void Insert(JourneyModel model) throws Exception {
        String query = "INSERT INTO Journey (UserId, JourneyId, CarId, IsDriver) VALUES (" + model.UserId + ", " + model.JourneyId + ", " + model.CarId + ", " + model.IsDriver + ");";
        int rs = ExecuteUpdate(query);
    }

    @Override
    public void Update(JourneyModel model) throws Exception {
        String query = "UPDATE Journey SET UserId = " + model.UserId + ", JourneyId = " + model.JourneyId + ", CarId = " + model.CarId + ", IsDriver = " + model.IsDriver + " WHERE Id = " + model.Id + ";";
        int rs = ExecuteUpdate(query);
    }

    @Override
    public void Delete(JourneyModel model) throws Exception {
        String query = "DELETE FROM Journey WHERE Id = " + model.Id + ";";
        int rs = ExecuteUpdate(query);
    }
}
