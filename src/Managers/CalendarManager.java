package Managers;

import DatabaseModels.CalendarModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Managers.DbManager.ExecuteQuery;
import static Managers.DbManager.ExecuteUpdate;

/**
 * Created by Johan on 09/03/2016.
 */
public class CalendarManager implements IManager<CalendarModel> {
    @Override
    public List<CalendarModel> GetAll() throws SQLException {
        List<CalendarModel> models = new ArrayList<>();
        ResultSet rs = ExecuteQuery("SELECT * FROM Calendar");

        while (rs.next()) {
            CalendarModel model = new CalendarModel();
            model.Id = rs.getInt("Id");
            model.UserId = rs.getInt("UserId");
            model.MondayStart = rs.getString("MondayStart");
            model.MondayEnd = rs.getString("MondayEnd");
            model.TuesdayStart = rs.getString("TuesdayStart");
            model.TuesdayEnd = rs.getString("TuesdayEnd");
            model.WenesdayStart = rs.getString("WenesdayStart");
            model.WenesdayEnd = rs.getString("WenesdayEnd");
            model.ThursdayStart = rs.getString("ThursdayStart");
            model.ThursdayEnd = rs.getString("ThursdayEnd");
            model.FridayStart = rs.getString("FridayStart");
            model.FridayEnd = rs.getString("FridayEnd");
            model.SaturdayStart = rs.getString("SaturdayStart");
            model.SaturdayEnd = rs.getString("SaturdayEnd");
            model.SundayStart = rs.getString("SundayStart");
            model.SundayEnd = rs.getString("SundayEnd");
            models.add(model);
        }

        rs.close();
        return models;
    }

    @Override
    public CalendarModel Get(String userId) throws SQLException {
        ResultSet rs = ExecuteQuery("SELECT * FROM Calendar WHERE UserId =" + userId + "");
        CalendarModel model = new CalendarModel();
        while (rs.next()) {
            model.UserId = rs.getInt("UserId");
            model.MondayStart = rs.getString("MondayStart");
            model.MondayEnd = rs.getString("MondayEnd");
            model.TuesdayStart = rs.getString("TuesdayStart");
            model.TuesdayEnd = rs.getString("TuesdayEnd");
            model.WenesdayStart = rs.getString("WenesdayStart");
            model.WenesdayEnd = rs.getString("WenesdayEnd");
            model.ThursdayStart = rs.getString("ThursdayStart");
            model.ThursdayEnd = rs.getString("ThursdayEnd");
            model.FridayStart = rs.getString("FridayStart");
            model.FridayEnd = rs.getString("FridayEnd");
            model.SaturdayStart = rs.getString("SaturdayStart");
            model.SaturdayEnd = rs.getString("SaturdayEnd");
            model.SundayStart = rs.getString("SundayStart");
            model.SundayEnd = rs.getString("SundayEnd");
        }
        rs.close();
        return model;
    }

    @Override
    public void Insert(CalendarModel model) throws Exception {
        String query = "INSERT INTO Calendar (UserId, MondayStart, MondayEnd, TuesdayStart, TuesdayEnd, WenesdayStart, WenesdayEnd, ThursdayStart, ThursdayEnd, FridayStart, FridayEnd, SaturdayStart, SaturdayEnd, SundayStart, SundayEnd)" +
                "VALUES (" + model.UserId + ",  " + model.MondayStart + ",  " + model.MondayEnd + ",  " + model.TuesdayStart + ",  " + model.TuesdayEnd + ",  " + model.WenesdayStart + ",  " + model.WenesdayEnd + ",  " + model.ThursdayStart + ",  " + model.ThursdayEnd + ",  " + model.FridayStart + ",  " + model.FridayEnd + ",  " + model.SaturdayStart + ",  " + model.SaturdayStart + ", " + model.SundayStart + ",  " + model.SundayEnd + ")";
        int rs = ExecuteUpdate(query);
    }

    @Override
    public void Update(CalendarModel model) throws Exception {
        String query = "UPDATE Calendar SET Driver = " + model.UserId + ", MondayStart = " + model.MondayStart + ", MondayEnd = " + model.MondayEnd + ", TuesdayStart = " + model.TuesdayStart + ", TuesdayEnd = " + model.TuesdayEnd + ", WenesdayStart = " + model.WenesdayStart + ", WenesdayEnd = " + model.WenesdayEnd + ", ThursdayStart = " + model.ThursdayStart + ", ThursdayEnd = " + model.ThursdayEnd + ", FridayStart = " + model.FridayStart + ", FridayEnd = " + model.FridayEnd + ", SaturdayStart = " + model.SaturdayStart + ", SaturdayEnd = " + model.SaturdayStart + ", SundayStart = " + model.SundayStart + ", SundayEnd = " + model.SundayEnd + ") +" +
                " WHERE Id = " + model.Id + ";";
        int rs = ExecuteUpdate(query);
    }

    @Override
    public void Delete(CalendarModel model) throws Exception {
        String query = "DELETE FROM Calendar WHERE Id = " + model.Id + ";";
        int rs = ExecuteUpdate(query);
    }
}
