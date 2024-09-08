package peaksoft.pestaran_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.pestaran_task.dto.restaurant.RestaurantResponse;
import peaksoft.pestaran_task.entiti.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("select  new peaksoft.pestaran_task.dto.category.CategoryResponse(c.name)  from  Category c  ")
    List<RestaurantResponse> getAll ();


}
