package controllers;


import java.util.ArrayList;

/**
 * Created by swann on 07/03/2016.
 */
public class RouteManager {

    protected static java.lang.String AdreeseEcole;

    static {
        AdreeseEcole = "22 impasse charles tournier, Toulouse, France";
    }

    public static ArrayList<java.lang.String> GetRoutePoints(java.lang.String Depart)
    {
        ArrayList<String> routePoints = new ArrayList<String>();
        routePoints.add(0, new String("merde"));
        return  routePoints;

    }
}
