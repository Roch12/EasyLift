package DatabaseModels;

/**
 * Created by Johan on 09/03/2016.
 */
public class JourneyModel extends DbContext {
    public int UserId;
    public int JourneyId;
    public int CarId;
    public boolean IsDriver;
    public int PlaceAvailable;
}
