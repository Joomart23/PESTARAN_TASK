package peaksoft.pestaran_task.dto.menultem;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@Builder
public class MeniltemResponseGetAll {
    private String name;
    private String image;
    private int price;
    private String description;
    //вегетариандык болуп саналат
    private String isVegetarian;

    public MeniltemResponseGetAll(String name, String image, int price, String description, String isVegetarian) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.description = description;
        this.isVegetarian = isVegetarian;
    }
}
