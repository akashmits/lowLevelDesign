package machinecodinground.pojo;

import lombok.Data;
import machinecodinground.Address;

import java.util.List;


@Data
public class AddRestaurantPojo {
    String restaurantName;
    Address address;
    List<TableInfoPojo> list;
}
