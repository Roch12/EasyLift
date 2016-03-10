package controllers.Map;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by swann on 07/03/2016.
 */
public class RouteManager {

    protected static java.lang.String AdreeseEcole;



    static {

        AdreeseEcole = "22%20impasse%20charles%20fourrier%20Toulouse,France";
    }

    public  static Coordinate GetClosestCoordinateFromStart(Coordinate start, ArrayList<Coordinate> coordinates)
    {

        double currentShortestDistance = GetDistanceBetweenTwoCoordinates(start, coordinates.get(0));
        int closestElementIndex = 0;
        for(int i = 1 ; i < coordinates.size();i++)
        {
            double temp = GetDistanceBetweenTwoCoordinates(start, coordinates.get(i));
            if(temp<currentShortestDistance)
            {
                closestElementIndex = i;
                currentShortestDistance = temp;
            }
        }
        return  coordinates.get(closestElementIndex);
    }

    ///Return the distance (a vol d'oiseau) between two coordinates in meters
    public static double GetDistanceBetweenTwoCoordinates(Coordinate coord1, Coordinate coord2)
    {
        double result=0;
        double R = 6371000; // earth radius in meters
        double lat1InRadians = Math.toRadians(coord1.Latitude);
        double lat2InRadians =  Math.toRadians(coord2.Latitude);
        double deltaLatitude = Math.toRadians(coord2.Latitude-coord1.Latitude);
        double deltaLongitude =  Math.toRadians(coord2.Longitude-coord1.Longitude);

        double a = Math.sin(deltaLatitude/2) * Math.sin(deltaLatitude/2) +
                Math.cos(lat1InRadians) * Math.cos(lat2InRadians) *
                        Math.sin(deltaLongitude/2) * Math.sin(deltaLongitude/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        result = R * c;

        return result;
    }



    public static ArrayList<java.lang.String> GetRouteWaypoints(java.lang.String Depart) throws IOException, JSONException {

        JSONArray jRoutes = null;
        JSONArray jLegs = null;
        JSONArray jSteps = null;
        ArrayList<String> routePoints = new ArrayList<String>();
        String JSONResult = GMapApiManager.GetWapointsBetweenToLocationsAsJSON(Depart,AdreeseEcole);
       JSONObject jObject = new JSONObject(JSONResult);
        try {

            jRoutes = jObject.getJSONArray("routes");

            /** Traversing all routes */
            for(int i=0;i<jRoutes.length();i++){
                jLegs = ( (JSONObject)jRoutes.get(i)).getJSONArray("legs");


                /** Traversing all legs */
                for(int j=0;j<jLegs.length();j++){
                    jSteps = ( (JSONObject)jLegs.get(j)).getJSONArray("steps");

                    /** Traversing all steps */
                    for(int k=0;k<jSteps.length();k++){

                        String html_instructions = ((JSONObject)jSteps.get(k)).getString("html_instructions");
                        String travel_mode = ((JSONObject)jSteps.get(k)).getString("travel_mode");
                       // String maneuver = ((JSONObject)jSteps.get(k)).getString("maneuver");

                        //String distance_text = ((JSONObject)jSteps.get(k)).getJSONObject("distance").getString("text");
                        //String distance_value = ((JSONObject)jSteps.get(k)).getJSONObject("distance").getString("value");
//
                        //String duration_text = ((JSONObject)jSteps.get(k)).getJSONObject("duration").getString("text");
                        //String duration_value = ((JSONObject)jSteps.get(k)).getJSONObject("duration").getString("value");

                        double start_lat = ((JSONObject)jSteps.get(k)).getJSONObject("start_location").getDouble("lat");
                        double start_lon = ((JSONObject)jSteps.get(k)).getJSONObject("start_location").getDouble("lng");

                        double end_lat = ((JSONObject)jSteps.get(k)).getJSONObject("end_location").getDouble("lat");
                        double end_lon = ((JSONObject)jSteps.get(k)).getJSONObject("end_location").getDouble("lng");
                        System.out.println(end_lat+ "    "+ end_lon);
                        routePoints.add(new String(end_lat+ "    "+ end_lon));
                        //String polyline = "";
                       // polyline = (String)((JSONObject)((JSONObject)jSteps.get(k)).get("polyline")).get("points");



                        /** Traversing all points */

                    }

                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }catch (Exception e){
        }




            //routePoints.add(steps);

        return  routePoints;

    }
}
