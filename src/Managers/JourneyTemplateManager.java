package Managers;

import DatabaseModels.JourneyTemplateModel;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static Managers.DbManager.ExecuteQuery;
import static Managers.DbManager.ExecuteUpdate;

/**
 * Created by Johan on 09/03/2016.
 */
public class JourneyTemplateManager implements IManager<JourneyTemplateModel> {
    @Override
    public List<JourneyTemplateModel> GetAll() throws Exception {
        List<JourneyTemplateModel> models = new ArrayList<>();
        ResultSet rs = ExecuteQuery("SELECT * FROM JourneyTemplate;");
        while (rs.next()) {
            JourneyTemplateModel model = new JourneyTemplateModel();
            model.Id = rs.getInt("Id");
            model.UserId = rs.getInt("UserId");
            model.StartDateTime = rs.getDate("StartDateTime");
            model.PointCollection = rs.getString("PointCollection");
            model.StartLocation = rs.getString("StartLocation");
            model.PlaceAvailable = rs.getInt("PlaceAvailable");
            models.add(model);
        }
        rs.close();
        return models;
    }

    @Override
    public JourneyTemplateModel Get(String id) throws Exception {
        JourneyTemplateModel model = new JourneyTemplateModel();
        ResultSet rs = ExecuteQuery("SELECT * FROM JourneyTemplate WHERE Id = " + id + ";");

        while (rs.next()) {
            model.Id = rs.getInt("Id");
            model.UserId = rs.getInt("UserId");
            model.StartDateTime = rs.getDate("StartDateTime");
            model.PointCollection = rs.getString("PointCollection");
            model.StartLocation = rs.getString("StartLocation");
            model.PlaceAvailable = rs.getInt("PlaceAvailable");
        }
        rs.close();
        return model;
    }

    @Override
    public void Insert(JourneyTemplateModel model) throws Exception {
        String query = "INSERT INTO JourneyTemplate (StartLocation, PointCollection, StartDateTime, PlaceAvailable, UserId)" +
                " VALUES (" + model.StartLocation + ", " + model.PointCollection + ", " + model.StartDateTime + ", " + model.PlaceAvailable + ", "+model.UserId+");";
        int rs = ExecuteUpdate(query);
    }

    @Override
    public void Update(JourneyTemplateModel model) throws Exception {
        String query = "UPDATE JourneyTemplate SET " +
                "StartLocation = " + model.StartLocation + ", PointCollection = " + model.PointCollection + ", " +
                "StartDateTime = " + model.StartDateTime + ", PlaceAvailable = " + model.PlaceAvailable + " " +
                "WHERE Id = " + model.Id + ";";
        int rs = ExecuteUpdate(query);
    }

    @Override
    public void Delete(JourneyTemplateModel model) throws Exception {
        String query = "DELETE FROM JourneyTemplate WHERE Id = " + model.Id + ";";
        int rs = ExecuteUpdate(query);
    }
}
