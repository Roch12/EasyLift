package models;

import DatabaseModels.CalendarModel;

/**
 * Created by Johan on 10/03/2016.
 */
public class Calendar {
    public Day Monday;
    public Day Tuesday;
    public Day Wenesday;
    public Day Thursday;
    public Day Friday;
    public Day Saturday;
    public Day Sunday;

    public static Calendar CalendarModelToCalendar(CalendarModel model) {
        Calendar cal = new Calendar();

        cal.Monday = new Day(model.MondayStart, model.MondayEnd);
        cal.Tuesday = new Day(model.TuesdayStart, model.TuesdayEnd);
        cal.Wenesday = new Day(model.WenesdayStart, model.WenesdayEnd);
        cal.Thursday = new Day(model.ThursdayStart, model.ThursdayEnd);
        cal.Friday = new Day(model.FridayStart, model.FridayEnd);
        cal.Saturday = new Day(model.SaturdayStart, model.SaturdayEnd);
        cal.Sunday = new Day(model.SundayStart, model.SundayEnd);

        return cal;
    }
}
