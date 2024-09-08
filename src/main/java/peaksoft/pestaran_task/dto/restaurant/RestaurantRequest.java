package peaksoft.pestaran_task.dto.restaurant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class RestaurantRequest {
    private Long id;
    private String name;
    //жайгашкан жери
    private String location;
    //эс алуу түрү
    private String restType;
    //Кызматкерлердин саны
    private String numberOfEmployees;
    //услуга
    private String service;
}
