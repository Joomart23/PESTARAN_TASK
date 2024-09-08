package peaksoft.pestaran_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import peaksoft.pestaran_task.dto.menultem.MeniltemResponseGetAll;
import peaksoft.pestaran_task.dto.menultem.MenultemRequest;
import peaksoft.pestaran_task.dto.menultem.MenultemResponse;
import peaksoft.pestaran_task.dto.restaurant.RestaurantResponse;
import peaksoft.pestaran_task.entiti.Menultem;

import java.util.List;

public interface MenultemRepository extends JpaRepository<Menultem, Long> {
    @Query("select new peaksoft.pestaran_task.dto.menultem.MenultemResponse(m.name, s.name, c.name) " +
            "from Menultem m " +
            "inner join m.subcategory s " +
            "inner join s.category c " +
            "where m.name ilike %:word% " +
            "or s.name ilike %:word% " +
            "or c.name ilike %:word%")
    List<MenultemResponse> findMenultemByNameOrCategoryOrSubcategory(@Param("word") String word);
    @Query("select  new peaksoft.pestaran_task.dto.menultem.MeniltemResponseGetAll(m.name,m.image,m.price,m.description,m.isVegetarian) from Menultem m")
    MeniltemResponseGetAll getAll();

}
