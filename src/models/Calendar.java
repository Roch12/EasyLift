package models;

import DatabaseModels.CalendarModel;

/**
 * Created by Johan on 10/03/2016.
 */
public class Calendar {
    private Day Monday;
    private Day Tuesday;
    private Day Wenesday;
    private Day Thursday;
    private Day Friday;
    private Day Saturday;
    private Day Sunday;

    public static Calendar CalendarModelToCalendar(CalendarModel model) {
        Calendar cal = new Calendar();

        cal.setMonday(new Day(model.MondayStart, model.MondayEnd));
        cal.setTuesday(new Day(model.TuesdayStart, model.TuesdayEnd));
        cal.setWenesday(new Day(model.WenesdayStart, model.WenesdayEnd));
        cal.setThursday(new Day(model.ThursdayStart, model.ThursdayEnd));
        cal.setFriday(new Day(model.FridayStart, model.FridayEnd));
        cal.setSaturday(new Day(model.SaturdayStart, model.SaturdayEnd));
        cal.setSunday(new Day(model.SundayStart, model.SundayEnd));

        return cal;
    }

    public Day getMonday() {
        return Monday;
    }

    public void setMonday(Day monday) {
        Monday = monday;
    }

    public Day getTuesday() {
        return Tuesday;
    }

    public void setTuesday(Day tuesday) {
        Tuesday = tuesday;
    }

    public Day getWenesday() {
        return Wenesday;
    }

    public void setWenesday(Day wenesday) {
        Wenesday = wenesday;
    }

    public Day getThursday() {
        return Thursday;
    }

    public void setThursday(Day thursday) {
        Thursday = thursday;
    }

    public Day getFriday() {
        return Friday;
    }

    public void setFriday(Day friday) {
        Friday = friday;
    }

    public Day getSaturday() {
        return Saturday;
    }

    public void setSaturday(Day saturday) {
        Saturday = saturday;
    }

    public Day getSunday() {
        return Sunday;
    }

    public void setSunday(Day sunday) {
        Sunday = sunday;
    }
}
