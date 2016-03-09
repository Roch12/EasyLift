package Managers;

import DatabaseModels.LoginModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Managers.DbManager.*;

/**
 * Created by Johan on 04/03/2016.
 */
public final class LoginManager implements IManager<LoginModel> {

    @Override
    public List<LoginModel> GetAll() throws SQLException {
        List<LoginModel> models = new ArrayList<>();
        ResultSet rs = ExecuteQuery("SELECT * FROM Login");

        while (rs.next()) {
            LoginModel model = new LoginModel();
            model.Id  = rs.getInt("Id");
            model.Username = rs.getString("Username");
            model.Password = rs.getString("Password");
            model.UserId = rs.getInt("UserId");
            models.add(model);
        }

        rs.close();
        return models;
    }

    @Override
    public LoginModel Get(String username) throws SQLException {
        ResultSet rs = ExecuteQuery("SELECT * FROM Login WHERE Username LIKE(" + username + ")");
        LoginModel model = new LoginModel();
        while (rs.next()) {
            model.Id = rs.getInt("Id");
            model.Password = rs.getString("Password");
            model.Username = rs.getString("Username");
            model.UserId = rs.getInt("UserId");
        }
        rs.close();
        return model;
    }

    public LoginModel GetFromUserId(String userId) throws  SQLException {
        ResultSet rs = ExecuteQuery("SELECT * FROM Login WHERE UserId = " + userId + ";");
        LoginModel model = new LoginModel();
        while (rs.next()) {
            model.Id = rs.getInt("Id");
            model.Password = rs.getString("Password");
            model.Username = rs.getString("Username");
            model.UserId = rs.getInt("UserId");
        }
        rs.close();
        return model;
    }

    @Override
    public void Insert(LoginModel model) throws SQLException {
        String query = "INSERT INTO Login (Username, Password, UserId) " +
                "VALUES (" + model.Username + ", " + model.Password + ", "+model.UserId+");";
        int rs = ExecuteUpdate(query);
    }

    @Override
    public void Update(LoginModel model) throws SQLException {
        String query = "UPDATE Login SET Username = " + model.Username + ", Password = " + model.Password + ", UserId = "+model.UserId+" WHERE Id = " + model.Id + ";";
        int rs = ExecuteUpdate(query);
    }

    @Override
    public void Delete(LoginModel model) throws SQLException {
        String query = "DELETE FROM Login WHERE Id = " + model.Id + ";";
        int rs = ExecuteUpdate(query);
    }
}

