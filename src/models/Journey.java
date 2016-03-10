package models;

import DatabaseModels.*;
import Managers.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Johan on 10/03/2016.
 */
public class Journey {
    public Driver Driver;
    public List<Passenger> Passengers;
    public Calendar Schedule;
    private String StartLocation;

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
        String journeyTemplateId = Integer.toString(journeyTemplateModel.Id);
        Journey journey = new Journey();
        journey.setStartLocation(journeyTemplateModel.StartLocation);

        UserModel driverModel = new UserManager().Get(journeyTemplateId);
        LoginModel loginModel = new LoginManager().GetFromUserId(userId);
        CarModel carModel = new CarManager().Get(Integer.toString(driverModel.CarId));
        journey.Driver = models.Driver.UserModelToDriver(driverModel, carModel, loginModel);

        CalendarModel calendarModel = new CalendarManager().Get(userId);
        journey.Schedule = Calendar.CalendarModelToCalendar(calendarModel);

        List<JourneyModel> journeyModels = new JourneyManager().GetFromTemplate(journeyTemplateId);

        for (JourneyModel j : journeyModels) {
            UserModel passengerModel = new UserManager().Get(Integer.toString(j.UserId));
            Passenger passenger = Passenger.UserModelToPassenger(passengerModel);
            journey.Passengers.add(passenger);
        }

        return journey;
    }

    public models.Driver getDriver() {
        return Driver;
    }

    public void setDriver(models.Driver driver) {
        Driver = driver;
    }

    public List<Passenger> getPassengers() {
        return Passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        Passengers = passengers;
    }

    public Calendar getSchedule() {
        return Schedule;
    }

    public void setSchedule(Calendar schedule) {
        Schedule = schedule;
    }

    public String getStartLocation() {
        return StartLocation;
    }

    public void setStartLocation(String startLocation) {
        StartLocation = startLocation;
    }
}
