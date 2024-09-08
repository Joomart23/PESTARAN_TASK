package peaksoft.pestaran_task.service;

import peaksoft.pestaran_task.dto.SimpleResponse;
import peaksoft.pestaran_task.dto.subcategory.SubCategoruResponsoGetAll;
import peaksoft.pestaran_task.dto.subcategory.SubCategoryRequest;
import peaksoft.pestaran_task.dto.subcategory.SubCategoryResponse;

import java.util.List;

public interface SubcategoryService {
    SimpleResponse saveSupCategory(Long subCategory , SubCategoryRequest subCategoryRequest);
    SubCategoryResponse getAllSubCategoriesAndCategory(Long id);
  List< SubCategoruResponsoGetAll> getAllSubCategories();
    SimpleResponse deleteSubCategory(Long id);
    SimpleResponse updateSubCategory(Long id,SubCategoryRequest subCategoryRequest);

}
