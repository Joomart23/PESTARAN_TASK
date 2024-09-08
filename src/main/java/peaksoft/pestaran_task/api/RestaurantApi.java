package peaksoft.pestaran_task.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.pestaran_task.dto.SimpleResponse;
import peaksoft.pestaran_task.dto.restaurant.RestaurantRequest;
import peaksoft.pestaran_task.dto.restaurant.RestaurantResponse;
import peaksoft.pestaran_task.repository.RestaurantRepository;
import peaksoft.pestaran_task.service.RestaurantService;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantApi {

    private final RestaurantService restaurantService;
    private final RestaurantRepository  repositoryRestaurant;
    private final RestaurantRepository restaurantRepository;
    @PostMapping
    public RestaurantResponse save (@RequestBody RestaurantRequest restaurantResponse) {
       return  restaurantService .saveRestaurantRequest(restaurantResponse);
   }
   @GetMapping
    public List<RestaurantResponse> getAllRestaurants () {
       return restaurantRepository.getAllRestaurants();
   }
   @DeleteMapping("/{id}")
    public SimpleResponse deleteRestaurant (@PathVariable Long id) {
      return   restaurantService.deleteRestaurantRequest(id);
   }
   @PutMapping("{id}")
    public RestaurantResponse update ( @PathVariable Long id,@RequestBody RestaurantRequest restaurantResponse ) {
       return restaurantService.updateRestaurantRequest(id,restaurantResponse);
   }
}
