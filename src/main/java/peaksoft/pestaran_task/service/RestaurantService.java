package peaksoft.pestaran_task.service;

import peaksoft.pestaran_task.dto.SimpleResponse;
import peaksoft.pestaran_task.dto.restaurant.RestaurantRequest;
import peaksoft.pestaran_task.dto.restaurant.RestaurantResponse;

import java.util.List;

public interface RestaurantService {
    RestaurantResponse saveRestaurantRequest(RestaurantRequest restaurantRequest);
    List<RestaurantResponse> findAllRestaurantRequests();
    SimpleResponse deleteRestaurantRequest(Long id);
  RestaurantResponse updateRestaurantRequest(Long id, RestaurantRequest restaurantRequest);





}
