package peaksoft.pestaran_task.dto.subcategory;

import lombok.*;
import peaksoft.pestaran_task.entiti.Subcategory;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor

public class SubCategoryResponse {
    private String name;
    private List<Subcategory> subcategories;
    public SubCategoryResponse(String name) {
        this.name = name;
    }
}
