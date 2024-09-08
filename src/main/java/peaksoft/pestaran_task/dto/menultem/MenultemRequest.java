package peaksoft.pestaran_task.dto.menultem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MenultemRequest {
    private String name;
    private String image;
    private int price;
    private String description;
    //вегетариандык болуп саналат
    private String isVegetarian;
}
