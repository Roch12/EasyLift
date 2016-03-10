package controllers.Map;

/**
 * Created by swann on 09/03/2016.
 */
public class Coordinate {
    public  Coordinate()
    {

    }
    public  Coordinate(double lat, double lng)
    {
        Latitude = lat;
        Longitude = lng;
    }
    public  double Latitude;
    public  double Longitude;

    @Override
   public String toString()
   {
       return new String(Latitude+";"+Longitude+";");
   }
}
