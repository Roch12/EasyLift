package controllers;

/**
 * Created by swann on 09/03/2016.
 */
public class Coordinate {
    public  double Latitude;
    public  double Longitude;

   public String ToString()
   {
       return new String(Latitude+";"+Longitude+";");
   }
}
