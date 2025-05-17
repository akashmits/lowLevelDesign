package machinecodinground;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Restaurant {
    long id;
    String restaurantName;
    Address address;
    RestaurantType type;
    List<TableInfo> tablesInfo;


}
