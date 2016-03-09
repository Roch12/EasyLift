package controllers;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by swann on 08/03/2016.
 */
public class GMapApiManager {
    protected static String apikey;

    static {
        apikey = "AIzaSyCCvggOWVBuarW8ZN-7wIdG7Vtlgao4Aak";
    }

    public static String  QueryGMAPApi(String query) throws IOException {

       // String targeturl= new String( "https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key="+apikey);//YOUR_API_KEY";
        URL url = new URL(query);
        URLConnection yc = url.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine;
        String res = new String();
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            res+=inputLine;
        }
        in.close();
        return  res;

    }

    public  static String CoordinatesToAdrres(Coordinate coordinate) throws IOException, JSONException {
        String address = new String();
        String query = "https://maps.googleapis.com/maps/api/geocode/json?latlng="+coordinate.Latitude+","+coordinate.Longitude+"&key="+apikey;
        String queryJSONResult = QueryGMAPApi(query);
        JSONObject jObject = new JSONObject(queryJSONResult);
        try {
            String results = jObject.getString("results");
            JSONObject resultJSONObject = new JSONObject(results);
            address = resultJSONObject.getString("formatted_address");

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return  address;
    }

    public  static Coordinate AddressToCoordinate(String address) throws IOException, JSONException {
        Coordinate coordinateToReturn = new Coordinate();
        String query = "https://maps.googleapis.com/maps/api/geocode/json?address="+address+"&key="+apikey;
        String queryJSONResult = QueryGMAPApi(query);
        JSONObject jObject = new JSONObject(queryJSONResult);
        try {
         String results= jObject.getString("results");
            JSONObject resultJSONObject = new JSONObject(results);

           JSONObject geometry = resultJSONObject.getJSONObject("geometry");
          JSONObject location=  geometry.getJSONObject("location");
            double latitude = location.getDouble("lat");
            double longitude = location.getDouble("lng");
            coordinateToReturn.Latitude = latitude;
            coordinateToReturn.Longitude = longitude;

        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return  coordinateToReturn;
    }

    public static String GetWapointsBetweenToLocationsAsJSON(String startLocation, String destinationLocation) throws IOException {
        String query = "https://maps.googleapis.com/maps/api/directions/json?origin="+startLocation+"&destination="+destinationLocation+"&key="+apikey;


        //URL url = new URL(query);
        //URLConnection yc = url.openConnection();
        //BufferedReader in = new BufferedReader(
        //        new InputStreamReader(
        //                yc.getInputStream()));
        //String inputLine;
        //String res = new String();
        //while ((inputLine = in.readLine()) != null) {
        //    System.out.println(inputLine);
        //    res+=inputLine;
        //}
        //in.close();
        return  QueryGMAPApi(query);

    }
}
