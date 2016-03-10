package controllers;

/**
 * Created by Maxime on 04/03/2016.
 */

import models.Journey;
import models.Tile;
import models.extensions.TileExtension;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class JourneyController {

    @RequestMapping(value = "/Journey",method = RequestMethod.GET)
    public String printHello(@RequestParam("id")int id,ModelMap model) {
        try {
            model.addAttribute("journey",Journey.RetrieveAJourney(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }

    @RequestMapping(value="/Search", method=RequestMethod.GET)
    public String search(ModelMap model) {
        List<Tile> listTile = null;
        try {
            listTile = TileExtension.RetrieveAllTiles(-1);
            model.addAttribute("Tiles", listTile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "search";
    }
}
