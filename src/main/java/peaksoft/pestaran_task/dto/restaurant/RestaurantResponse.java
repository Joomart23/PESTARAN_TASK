package peaksoft.pestaran_task.dto.restaurant;

import lombok.*;

@Setter
@Getter
@Builder
public class RestaurantResponse {
    private String name;
    //жайгашкан жери
    private String  location;
    //эс алуу түрү
    private String restType;
    //Кызматкерлердин саны
    private String numberOfEmployees;
    //услуга
    private String service;
    public RestaurantResponse(String name, String location, String restType, String numberOfEmployees, String service) {
        this.name = name;
        this.location = location;
        this.restType = restType;
        this.numberOfEmployees = numberOfEmployees;
        this.service = service;
    }
}

