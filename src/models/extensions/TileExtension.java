package models.extensions;

import DatabaseModels.*;
import Managers.*;
import models.Tile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Johan on 09/03/2016.
 */
public class TileExtension {

    public static Tile UsernameToTile(String username) throws Exception {
        LoginModel login = new LoginManager().Get(username);
        UserModel user = new UserManager().Get(Integer.toString(login.UserId));
        CarModel car = new CarManager().Get(Integer.toString(user.CarId));
        JourneyTemplateModel journeyTemplate = new JourneyTemplateManager().Get(Integer.toString(user.JourneyTemplateId));

        return new Tile(user.Id, login.Username, user.Firstname, user.Lastname, journeyTemplate.StartDateTime, journeyTemplate.PlaceAvailable, car.Seats, journeyTemplate.StartLocation, user.Promotion);
    }

    public static List<Tile> RetrieveAllTiles() throws Exception {
        List<JourneyTemplateModel> journeyTemplateModelList = new JourneyTemplateManager().GetAll();

        if (journeyTemplateModelList.size() <= 0)
            return null;

        List<Tile> tiles = new ArrayList<>();

        for (JourneyTemplateModel journeyTemplate : journeyTemplateModelList) {
            UserModel user = new UserManager().Get(Integer.toString(journeyTemplate.UserId));
            LoginModel login = new LoginManager().Get(Integer.toString(user.Id));
            CarModel car = new CarManager().Get(Integer.toString(user.CarId));

            Tile tile = new Tile(user.Id, login.Username, user.Firstname, user.Lastname, journeyTemplate.StartDateTime, journeyTemplate.PlaceAvailable, car.Seats, journeyTemplate.StartLocation, user.Promotion);
            tiles.add(tile);
        }

        return tiles;
    }
}