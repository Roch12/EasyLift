package controllers;

/**
 * Created by Maxime on 04/03/2016.
 */

import models.Tile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        ArrayList<Tile> listTile = new ArrayList<Tile>();
        listTile.add(new Tile(0,"JoseZorro","Jose","San miguel de la rosa",new Date(),2,4,"ici"));
        model.addAttribute("Tiles", listTile);
        return "index";
    }
}
