package controllers;

/**
 * Created by swann on 07/03/2016.
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
@RequestMapping("/")
public class MapController {
    @RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap model) throws IOException {
//        String gmaptest = new GMapApiTest().GMapApiTestOfTest();
//        model.addAttribute("result", gmaptest);

        return "map";
    }

    void RegisterUserLocation()
    {

    }
}
