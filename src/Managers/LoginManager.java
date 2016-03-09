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
            LoginModel loginModel = new LoginModel();
            loginModel.Id  = rs.getInt("Id");
            loginModel.Username = rs.getString("Username");
            loginModel.Password = rs.getString("Password");
            models.add(loginModel);
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
        }
        rs.close();
        return model;
    }

    @Override
    public void Insert(LoginModel model) throws SQLException {
        String query = "INSERT INTO Login (Username, Password) " +
                "VALUES (" + model.Username + ", " + model.Password + ");";
        int rs = ExecuteUpdate(query);
    }

    @Override
    public void Update(LoginModel model) throws SQLException {
        String query = "UPDATE Login SET Username = " + model.Username + ", Password = " + model.Password + " WHERE Id = " + model.Id + ";";
        int rs = ExecuteUpdate(query);
    }

    @Override
    public void Delete(LoginModel model) throws SQLException {
        String query = "DELETE FROM Login WHERE Id = " + model.Id + ";";
        int rs = ExecuteUpdate(query);
    }
}

