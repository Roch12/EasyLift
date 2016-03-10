package models.extensions;

import DatabaseModels.*;
import Managers.*;
import controllers.Map.Coordinate;
import controllers.Map.GMapApiManager;
import models.Tile;

import java.util.ArrayList;
import java.util.Arrays;
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
        List<String> coordinateList = new ArrayList<String>(Arrays.asList(journeyTemplate.StartLocation.split(",")));
        String addressStartLocation = GMapApiManager.CoordinatesToAdrres(new Coordinate(Double.parseDouble(coordinateList.get(0)),Double.parseDouble(coordinateList.get(1))));
        return new Tile(journeyTemplate.Id, login.Username, user.Firstname, user.Lastname, journeyTemplate.StartDateTime, journeyTemplate.PlaceAvailable, car.Seats, journeyTemplate.StartLocation, user.Promotion, addressStartLocation, user.Picture);
    }

    public static List<Tile> RetrieveAllTiles(int limitation) throws Exception {
        List<JourneyTemplateModel> journeyTemplateModelList = null;
        if(limitation == -1)
            journeyTemplateModelList = new JourneyTemplateManager().GetAll();
        else
            journeyTemplateModelList = new JourneyTemplateManager().GetAll(limitation);

        if (journeyTemplateModelList.size() <= 0)
            return null;

        List<Tile> tiles = new ArrayList<>();

        for (JourneyTemplateModel journeyTemplate : journeyTemplateModelList) {
            UserModel user = new UserManager().Get(Integer.toString(journeyTemplate.UserId));
            LoginModel login = new LoginManager().GetFromUserId(Integer.toString(user.Id));
            CarModel car = new CarManager().Get(Integer.toString(user.CarId));

            List<String> coordinateList = new ArrayList<String>(Arrays.asList(journeyTemplate.StartLocation.split(",")));
            String addressStartLocation = GMapApiManager.CoordinatesToAdrres(new Coordinate(Double.parseDouble(coordinateList.get(0)),Double.parseDouble(coordinateList.get(1))));
            tiles.add(new Tile(journeyTemplate.Id, login.Username, user.Firstname, user.Lastname, journeyTemplate.StartDateTime, journeyTemplate.PlaceAvailable, car.Seats, journeyTemplate.StartLocation, user.Promotion, addressStartLocation, user.Picture));
        }

        return tiles;
    }
}
