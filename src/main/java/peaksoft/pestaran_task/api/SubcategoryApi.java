package peaksoft.pestaran_task.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.pestaran_task.dto.SimpleResponse;
import peaksoft.pestaran_task.dto.subcategory.SubCategoruResponsoGetAll;
import peaksoft.pestaran_task.dto.subcategory.SubCategoryRequest;
import peaksoft.pestaran_task.dto.user.UserResponse;
import peaksoft.pestaran_task.entiti.Subcategory;
import peaksoft.pestaran_task.repository.SubcategoryRepository;
import peaksoft.pestaran_task.service.SubcategoryService;

import java.util.List;

@RestController
@RequestMapping("/Subcategory")
@RequiredArgsConstructor
public class SubcategoryApi {
    private final SubcategoryService mSubcategoryService;
    private final SubcategoryRepository subcategoryRepository;

    @PostMapping("{id}")
    public SimpleResponse saveCategory( @PathVariable Long id, @RequestBody SubCategoryRequest subCategoryRequest) {
        return mSubcategoryService.saveSupCategory(id, subCategoryRequest );
    }
    @GetMapping("{id}")
    public List<Subcategory> getSubCategory(@PathVariable Long id ) {
        return subcategoryRepository.findByCategoryId(id);
    }
    @GetMapping
    public List<SubCategoruResponsoGetAll> getAllSubCategory() {
        return mSubcategoryService.getAllSubCategories();
    }
    @PutMapping("{id}")
    public SimpleResponse updateSubCategory(@PathVariable Long id, @RequestBody SubCategoryRequest subCategoryRequest) {
        return mSubcategoryService.updateSubCategory(id, subCategoryRequest );
    }
    @DeleteMapping("{id}")
    public SimpleResponse deleteSubCategory(@PathVariable Long id) {
        return mSubcategoryService.deleteSubCategory(id);
    }
}
