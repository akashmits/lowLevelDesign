package machinecodinground;

import machinecodinground.pojo.AddRestaurantPojo;

import java.util.List;

public interface RestaurantManager {

    public String addRestaurant(AddRestaurantPojo addRestaurantPojo);
    public String addTables(AddRestaurantPojo addRestaurantPojo);

    // update details part later

    public List<Restaurant> getRestaurant(String city);




}
