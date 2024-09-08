package peaksoft.pestaran_task.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.pestaran_task.dto.SimpleResponse;
import peaksoft.pestaran_task.dto.subcategory.SubCategoruResponsoGetAll;
import peaksoft.pestaran_task.dto.subcategory.SubCategoryRequest;
import peaksoft.pestaran_task.dto.subcategory.SubCategoryResponse;
import peaksoft.pestaran_task.entiti.Category;
import peaksoft.pestaran_task.entiti.Subcategory;
import peaksoft.pestaran_task.repository.CategoryRepository;
import peaksoft.pestaran_task.repository.SubcategoryRepository;
import peaksoft.pestaran_task.service.SubcategoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubcategoryImpl implements SubcategoryService {
    private final SubcategoryRepository subcategoryRepository;
    private final CategoryRepository categoryRepository;
    @Override
    public SimpleResponse saveSupCategory(Long categoryId, SubCategoryRequest subCategoryRequest) {
        if (subCategoryRequest.getName() == null || subCategoryRequest.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Subcategory аты бош болбошу керек");
        }
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NoSuchElementException("Category not found with ID: " + categoryId));
        Subcategory subcategoryEntity = new Subcategory();
        subcategoryEntity.setName(subCategoryRequest.getName());
        subcategoryEntity.setCategory(category);
        category.getSubcategories().add(subcategoryEntity);
        subcategoryRepository.save(subcategoryEntity);
        return new SimpleResponse(HttpStatus.OK, "Subcategory ийгиликтүү сакталды");
    }

    @Override
    public SubCategoryResponse getAllSubCategoriesAndCategory(Long id) {
//        Category category = categoryRepository.findById(id)
//                .orElseThrow(() -> new NoSuchElementException("Category not found with ID: " + id));
//        String categoryName = category.getName();
//        List<Subcategory> subcategoryList = subcategoryRepository.findByCategoryId(id);
//        SubCategoryResponse response = new SubCategoryResponse();
//        response.setName(categoryName);
//        response.setSubcategories(subcategoryList);
      return null;
////    }
   }

    @Override
    public List<SubCategoruResponsoGetAll> getAllSubCategories() {
        List<Subcategory> subcategories = subcategoryRepository.findAll();
        List<SubCategoruResponsoGetAll> subcategoriesResponse = new ArrayList<>();
        for (Subcategory subcategory : subcategories) {
            subcategoriesResponse.add(SubCategoruResponsoGetAll.builder()
                            .name(subcategory.getName())
                    .build());
        }
        return subcategoriesResponse;
    }
    @Override
    public SimpleResponse deleteSubCategory(Long id) {
       Subcategory category = subcategoryRepository.findById(id)
               .orElseThrow(() -> new NoSuchElementException("Category not found with ID: " + id));
       subcategoryRepository.delete(category);
        return  new SimpleResponse(
                HttpStatus.OK,
                "очту"
        );
    }
    @Override
    public SimpleResponse updateSubCategory(Long id,SubCategoryRequest subCategoryRequest) {
        Subcategory category = subcategoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Category not found with ID: " + id));
        category.setName(subCategoryRequest.getName());
        subcategoryRepository.save(category);
        return new SimpleResponse(
                HttpStatus.OK,
                "алмашылды"
        );
    }
}