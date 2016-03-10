package controllers;

/**
 * Created by Maxime on 04/03/2016.
 */

import models.Tile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class JourneyController {

    @RequestMapping(value = "/Journey",method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        return "index";
    }

    @RequestMapping(value="/Search", method=RequestMethod.GET)
    public String search(ModelMap model) {

        model.addAttribute("tile", new Tile(0,"JoseZorro","Jose","San miguel de la rosa",new Date(),2,4,"ici","Master 2", ""));
        return "search";
    }
}
