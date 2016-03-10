package models;

/**
 * Created by Johan on 10/03/2016.
 */
public class Day {
    private String Start;
    private String End;

    public Day() {}

    public Day(String start, String end) {
        setStart(start);
        setEnd(end);
    }

    public String getStart() {
        return Start;
    }

    public void setStart(String start) {
        Start = start;
    }

    public String getEnd() {
        return End;
    }

    public void setEnd(String end) {
        End = end;
    }
}
