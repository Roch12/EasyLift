package controllers;

/**
 * Created by swann on 07/03/2016.
 */
import controllers.Map.Coordinate;
import controllers.Map.GMapApiManager;
import controllers.Map.RouteManager;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.ArrayList;

@Controller
@RequestMapping("/Map")
public class MapController {
    @RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap model) throws IOException, JSONException {

       //ArrayList<String> result = RouteManager.GetRouteWaypoints("Toulouse");
        String result = "Adresse de 43.600000, 1.433333= "+ GMapApiManager.CoordinatesToAdrres(new Coordinate( 43.600000, 1.433333));
      //  result+= " Coordonnes de 22 impasse charles fourrier = "+  GMapApiManager.AddressToCoordinate("22%20impasse%20charles%20fourrier,toulouse");

        //result = "Distance Toulouse - Paris  =  "+ RouteManager.GetDistanceBetweenTwoCoordinates(GMapApiManager.AddressToCoordinate("Toulouse"), GMapApiManager.AddressToCoordinate("Paris"));
        ArrayList<Coordinate> myCoodinates = new ArrayList<Coordinate>();
        myCoodinates.add(GMapApiManager.AddressToCoordinate("Paris"));
        myCoodinates.add(GMapApiManager.AddressToCoordinate("Lyon"));
        myCoodinates.add(GMapApiManager.AddressToCoordinate("Brest"));
        myCoodinates.add(GMapApiManager.AddressToCoordinate("Auch"));
        Coordinate res = RouteManager.GetClosestCoordinateFromStart(GMapApiManager.AddressToCoordinate("Toulouse"),myCoodinates );

        result = "The closest city from Toulouse between : Paris, Lyon, Brest and Auch is =  "+ GMapApiManager.CoordinatesToAdrres(res) ;


        model.addAttribute("result", result.toString());

        return "map";
    }

    void RegisterUserLocation()
    {

    }
}
