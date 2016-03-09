package controllers;

/**
 * Created by Maxime on 04/03/2016.
 */

import models.Tile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping("/Profile")
public class ProfileController {

    @RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        ArrayList<Tile> listTile = new ArrayList<Tile>();
        listTile.add(new Tile(0,"JoseZorro","Jose","San miguel de la rosa",new Date(),2,4,"ici","Master 2"));
        listTile.add(new Tile(0,"JoseZorro","Jose","San miguel de la rosa",new Date(),2,4,"ici", "Bachelor 2"));
        model.addAttribute("Tiles", listTile);
        return "index";
    }
}
