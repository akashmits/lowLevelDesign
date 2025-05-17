package machinecodinground;

import machinecodinground.pojo.AddRestaurantPojo;
import machinecodinground.pojo.TableInfoPojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RestaurantManagerImpl implements RestaurantManager{

    Map<String, List<Restaurant>> citywiseRestaurantList;

    public RestaurantManagerImpl(){
        citywiseRestaurantList= new ConcurrentHashMap<>();
    }


    @Override
    public  synchronized String addRestaurant(AddRestaurantPojo addRestaurantPojo) {
        String city= addRestaurantPojo.getAddress().getCity();

            List<Restaurant> restaurants = citywiseRestaurantList.get(city);

            //duplicate check of restaurant

            if (restaurants == null) {
                restaurants = new ArrayList<>();
            }

            List<TableInfo> tableInfo = new ArrayList<>();
            int seqNo = 1;
            for (TableInfoPojo table : addRestaurantPojo.getList()) {
                for (int i = 0; i < table.getNoOftable(); i++) {
                    TableInfo tableEntry = TableInfo.builder().no(seqNo++).isOccupied(false).minCapacity(table.getMinCapacity() == 0 ? 1 : table.getMinCapacity())
                            .maxCapacity(table.getMaxCapacity() == 0 ? 1 : table.getMaxCapacity()).build();
                    tableInfo.add(tableEntry);
                }
            }

            Restaurant res = Restaurant.builder().restaurantName(addRestaurantPojo.getRestaurantName()).address(addRestaurantPojo.getAddress()).tablesInfo(tableInfo)
                    .id(restaurants.size() + 1).build();
            restaurants.add(res);
            citywiseRestaurantList.put(city, restaurants);

        return "Restaurant added in the list. Restaurant Id:";
    }

    //admin can add table in restaurant later
    @Override
    public String addTables(AddRestaurantPojo addRestaurantPojo) {
        return null;
    }

    @Override
    public List<Restaurant> getRestaurant(String city) {
       return new ArrayList<>(citywiseRestaurantList.get(city));
    }
}
//1 adding
// create array list
//

