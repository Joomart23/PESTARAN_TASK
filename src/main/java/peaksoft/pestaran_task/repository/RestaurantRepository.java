package peaksoft.pestaran_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.pestaran_task.dto.restaurant.RestaurantResponse;
import peaksoft.pestaran_task.entiti.Restaurant;

import java.util.List;
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query("select new peaksoft.pestaran_task.dto.restaurant.RestaurantResponse(r.name,r.service,r.restType,r.numberOfEmployees,r.location) from Restaurant r")
    List<RestaurantResponse> getAllRestaurants();
    @Query("select new peaksoft.pestaran_task.dto.restaurant.RestaurantResponse(r.name,r.service,r.restType,r.numberOfEmployees,r.location) from Restaurant r where r.id=:id")
    RestaurantResponse getRestaurantById(Long id);
    @Query("select new peaksoft.pestaran_task.dto.restaurant.RestaurantResponse(r.name,r.service,r.restType,r.numberOfEmployees,r.location) from Restaurant r where r.id=:userid" )
    RestaurantResponse restaurantAntUser(Long userid );



}
