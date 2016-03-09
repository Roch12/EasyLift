package models.extensions;

import DatabaseModels.*;
import Managers.*;
import models.Tile;

/**
 * Created by Johan on 09/03/2016.
 */
public class TileExtension {

    public static Tile UsernameToTile(String username) throws Exception {
        LoginModel login = new LoginManager().Get(username);
        UserModel user = new UserManager().Get(Integer.toString(login.UserId));
        CarModel car = new CarManager().Get(Integer.toString(user.CarId));
        JourneyTemplateModel journeyTemplate = new JourneyTemplateManager().Get(Integer.toString(user.JourneyTemplateId));
        JourneyModel journey = new JourneyManager().GetFromTemplate(Integer.toString(user.JourneyTemplateId));

        return new Tile(user.Id, login.Username, user.Firstname, user.Lastname, journeyTemplate.StartDateTime, journey.PlaceAvailable, car.Seats, journeyTemplate.StartLocation);
    }

}
