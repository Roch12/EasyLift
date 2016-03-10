package models;

import DatabaseModels.CarModel;
import DatabaseModels.JourneyModel;
import DatabaseModels.JourneyTemplateModel;
import DatabaseModels.UserModel;
import Managers.CarManager;
import Managers.JourneyManager;
import Managers.JourneyTemplateManager;
import Managers.UserManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Johan on 10/03/2016.
 */
public class Journey {
    public Driver driver;
    public List<Passenger> Passengers;
    public Calendar Schedule;

    public Journey() {
        Passengers = new ArrayList<>();
    }

    public static Journey RetrieveAJourney(int id) throws Exception {
        JourneyTemplateModel journeyTemplateModel = new JourneyTemplateManager().Get(Integer.toString(id));

        if (journeyTemplateModel == null)
            return null;
        if (journeyTemplateModel.UserId <= 0)
            return null;

        String userId = Integer.toString(journeyTemplateModel.UserId);
        Journey journey = new Journey();
        UserModel driverModel = new UserManager().Get(Integer.toString(journeyTemplateModel.UserId));
        CarModel carModel = new CarManager().Get(Integer.toString(driverModel.CarId));
        Driver driver = Driver.UserModelToDriver(driverModel, carModel);

        List<JourneyModel> journeyModels = new JourneyManager().GetFromTemplate(Integer.toString(journeyTemplateModel.Id));

        for (JourneyModel j : journeyModels) {
            UserModel passengerModel = new UserManager().Get(Integer.toString(j.UserId));
            Passenger passenger = Passenger.UserModelToPassenger(passengerModel);
            journey.Passengers.add(passenger);
        }

        return journey;
    }
}
