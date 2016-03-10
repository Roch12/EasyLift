package controllers;

/**
 * Created by Maxime on 04/03/2016.
 */

import models.Tile;
import models.extensions.TileExtension;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        List<Tile> listTile = null;
        try {
            listTile = TileExtension.RetrieveAllTiles();
            model.addAttribute("Tiles", listTile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "index";
    }
}
