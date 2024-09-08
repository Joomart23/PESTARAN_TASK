package peaksoft.pestaran_task.service;

import peaksoft.pestaran_task.dto.SimpleResponse;
import peaksoft.pestaran_task.dto.category.CategoryRequest;
import peaksoft.pestaran_task.dto.category.CategoryResponse;
import peaksoft.pestaran_task.entiti.Category;

import java.util.List;

public interface CategoryService {
    CategoryResponse getCategory(Long id);
    List<CategoryResponse> getCategories();
    SimpleResponse saveCategory(CategoryRequest category);
    SimpleResponse deleteCategory(Long id);
    SimpleResponse updateCategory(Long id,CategoryRequest category);


}
