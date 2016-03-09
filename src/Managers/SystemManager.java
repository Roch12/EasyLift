package Managers;

import DatabaseModels.SystemModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static Managers.DbManager.ExecuteQuery;

/**
 * Created by Johan on 09/03/2016.
 */
public class SystemManager{

    public SystemModel Get() throws SQLException {
        ResultSet rs = ExecuteQuery("SELECT * FROM System;");
        SystemModel model = new SystemModel();
        while (rs.next()){
            model.SchoolLocation = rs.getString("SchoolLocation");
        }

        rs.close();
        return model;
    }
}
