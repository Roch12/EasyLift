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
            model.MondayStart = rs.getDate("MondayStart");
            model.MondayEnd = rs.getDate("MondayEnd");
            model.TuesdayStart = rs.getDate("TuesdayStart");
            model.TuesdayEnd = rs.getDate("TuesdayEnd");
            model.WenesdayStart = rs.getDate("WenesdayStart");
            model.WenesdayEnd = rs.getDate("WenesdayEnd");
            model.ThursdayStart = rs.getDate("ThursdayStart");
            model.ThursdayEnd = rs.getDate("ThursdayEnd");
            model.FridayStart = rs.getDate("FridayStart");
            model.FridayEnd = rs.getDate("FridayEnd");
            model.SaturdayStart = rs.getDate("SaturdayStart");
            model.SaturdayEnd = rs.getDate("SaturdayEnd");
            model.SundayStart = rs.getDate("SundayStart");
            model.SundayEnd = rs.getDate("SundayEnd");
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
            model.MondayStart = rs.getDate("MondayStart");
            model.MondayEnd = rs.getDate("MondayEnd");
            model.TuesdayStart = rs.getDate("TuesdayStart");
            model.TuesdayEnd = rs.getDate("TuesdayEnd");
            model.WenesdayStart = rs.getDate("WenesdayStart");
            model.WenesdayEnd = rs.getDate("WenesdayEnd");
            model.ThursdayStart = rs.getDate("ThursdayStart");
            model.ThursdayEnd = rs.getDate("ThursdayEnd");
            model.FridayStart = rs.getDate("FridayStart");
            model.FridayEnd = rs.getDate("FridayEnd");
            model.SaturdayStart = rs.getDate("SaturdayStart");
            model.SaturdayEnd = rs.getDate("SaturdayEnd");
            model.SundayStart = rs.getDate("SundayStart");
            model.SundayEnd = rs.getDate("SundayEnd");
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
