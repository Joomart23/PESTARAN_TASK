package peaksoft.pestaran_task.dto.menultem;

import lombok.*;

@NoArgsConstructor
@Builder
public class MenultemResponse {

    private String combinedName;
    private String subcategoryName;
    private String categoryName;

    public MenultemResponse(String combinedName, String subcategoryName, String categoryName) {
        this.combinedName = combinedName;
        this.subcategoryName = subcategoryName;
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "MenultemResponse{" +
                "combinedName='" + combinedName + '\'' +
                ", subcategoryName='" + subcategoryName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }

    public String getCombinedName() {
        return combinedName;
    }

    public void setCombinedName(String combinedName) {
        this.combinedName = combinedName;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
