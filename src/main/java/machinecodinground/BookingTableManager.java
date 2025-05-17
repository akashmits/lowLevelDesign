package machinecodinground;

import java.util.Date;
import java.util.List;

public interface BookingTableManager {
    public long  bookTable(long restaurantId, int noOfPeople, long userId, Date startTime, Date endTime); //bookingId

    public boolean cancleTable(long bookingId);


    public List<Booking> getBookingHistory(long userId, int pageNo);

}
