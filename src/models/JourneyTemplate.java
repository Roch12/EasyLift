package models;

import controllers.RouteManager;

import java.util.ArrayList;
import java.util.Date;
/**
 * Created by swann on 07/03/2016.

 */
public class JourneyTemplate {
    private int Id;
    private java.lang.String StartLocation;
    private ArrayList<String> PointsCollection;
    private Date StartDatetime;


    public JourneyTemplate(int id,java.lang.String startLocation, Date startDatetime) {
        Id = id;
        StartLocation = startLocation;
        PointsCollection =RouteManager.GetRoutePoints(StartLocation);
        StartDatetime = startDatetime;
    }

    public JourneyTemplate(int id,String startLocation,  ArrayList<String> pointsCollection, Date startDatetime) {
        Id = id;
        StartLocation = startLocation;
        PointsCollection = pointsCollection;
        StartDatetime = startDatetime;
    }

    public Date getStartDatetime() {
        return StartDatetime;
    }

    public void setStartDatetime(Date startDatetime) {
        StartDatetime = startDatetime;
    }


    public ArrayList<String> getPointsCollection() {
        return PointsCollection;
    }

public void setPointsCollection(ArrayList<String> pointsCollection) {
        PointsCollection = pointsCollection;
    }

    public String getStartLocation() {
        return StartLocation;
    }

    public void setStartLocation(String startLocation) {
        StartLocation = startLocation;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
