package controllers;

/**
 * Created by swann on 07/03/2016.
 */
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

       ArrayList<String> result = RouteManager.GetRouteWaypoints("Toulouse");
        model.addAttribute("result", result.toString());

        return "map";
    }

    void RegisterUserLocation()
    {

    }
}
