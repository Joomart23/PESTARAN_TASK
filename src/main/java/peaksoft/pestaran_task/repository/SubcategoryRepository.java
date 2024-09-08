package peaksoft.pestaran_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import peaksoft.pestaran_task.dto.category.CategoryRequest;
import peaksoft.pestaran_task.dto.subcategory.SubCategoryRequest;
import peaksoft.pestaran_task.dto.subcategory.SubCategoryResponse;
import peaksoft.pestaran_task.entiti.Subcategory;

import java.beans.JavaBean;
import java.util.List;

public interface SubcategoryRepository  extends JpaRepository<Subcategory, Long> {

    @Query("SELECT s FROM Subcategory s WHERE s.category.id = :categoryId ORDER BY s.name")
    List<Subcategory> findByCategoryId(@Param("categoryId") Long categoryId);
}