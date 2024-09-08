package peaksoft.pestaran_task.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.pestaran_task.dto.SimpleResponse;
import peaksoft.pestaran_task.dto.restaurant.RestaurantRequest;
import peaksoft.pestaran_task.dto.restaurant.RestaurantResponse;
import peaksoft.pestaran_task.entiti.Restaurant;
import peaksoft.pestaran_task.repository.RestaurantRepository;
import peaksoft.pestaran_task.service.RestaurantService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor

public class RestaurantImpl implements RestaurantService {
    private final RestaurantRepository repositoryRestaurant;

    @Override
    public RestaurantResponse saveRestaurantRequest(RestaurantRequest restaurantRequest) {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(restaurantRequest.getId());
        restaurant.setName(restaurantRequest.getName());
        restaurant.setLocation(restaurantRequest.getLocation());
        restaurant.setService(restaurantRequest.getService());
        repositoryRestaurant.save(restaurant);
        return RestaurantResponse.builder()
                .name(restaurant.getName())
                .service(restaurant.getService())
                .restType(restaurant.getRestType())
                .numberOfEmployees(restaurant.getNumberOfEmployees())
                .location(restaurant.getLocation())
                .build();
    }

    @Override
    public List<RestaurantResponse> findAllRestaurantRequests() {
        return List.of();
    }

    @Override
    public SimpleResponse deleteRestaurantRequest(Long id) {
        Restaurant restaurant = repositoryRestaurant.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Ресторан табылган жок, ID: " + id));
       repositoryRestaurant.delete(restaurant);
       return  new SimpleResponse(
               HttpStatus.OK,
               "очту"
       );
    }
    @Override
    public RestaurantResponse updateRestaurantRequest(Long id, RestaurantRequest restaurantRequest) {
        Restaurant restaurant = repositoryRestaurant.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Ресторан табылган жок, ID: " + id));
        restaurant.setLocation(restaurantRequest.getLocation());
        restaurant.setService(restaurantRequest.getService());
        restaurant.setName(restaurantRequest.getName());
        repositoryRestaurant.save(restaurant);
        return RestaurantResponse.builder()
                .name(restaurant.getName())
                .service(restaurant.getService())
                .restType(restaurant.getRestType())
                .numberOfEmployees(restaurant.getNumberOfEmployees())
                .location(restaurant.getLocation())
                .build();
    }



}