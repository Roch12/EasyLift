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
        return "index";
    }
}
