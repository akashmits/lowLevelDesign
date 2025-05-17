package machinecodinground;

import java.util.Date;
import java.util.List;

public class BookingTableManagerImpl implements BookingTableManager{

    RestaurantManager restaurantManager;

    public BookingTableManagerImpl(){

    }





    @Override
    public long bookTable(long restaurantId, int noOfPeople, long userId, Date startTime, Date endTime) {
        return 0;
    }

    @Override
    public boolean cancleTable(long bookingId) {
        return false;
    }

    @Override
    public List<Booking> getBookingHistory(long userId, int pageNo) {
        return null;
    }
}
