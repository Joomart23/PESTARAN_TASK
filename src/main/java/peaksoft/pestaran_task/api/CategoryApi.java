package peaksoft.pestaran_task.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.pestaran_task.dto.SimpleResponse;
import peaksoft.pestaran_task.dto.category.CategoryRequest;
import peaksoft.pestaran_task.dto.category.CategoryResponse;
import peaksoft.pestaran_task.entiti.Category;
import peaksoft.pestaran_task.repository.CategoryRepository;
import peaksoft.pestaran_task.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryApi {
    private final CategoryService mCategoryService;
    private final CategoryRepository CategoryRepository;

    @PostMapping("/{id}save")
    public SimpleResponse saveSubCategory(@RequestBody CategoryRequest categoryRequest) {
        return mCategoryService.saveCategory(categoryRequest);
    }
    @PostMapping("{id}")
    public SimpleResponse updateCategory(@PathVariable Long id ,@RequestBody CategoryRequest categoryRequest ) {
        return mCategoryService.updateCategory(id, categoryRequest);
    }
    @DeleteMapping("{id}")
    public SimpleResponse deleteCategory(@PathVariable Long id) {
        return mCategoryService.deleteCategory(id);
    }
    @GetMapping()
    public List<CategoryResponse> getAllCategories() {
        return mCategoryService.getCategories();
    }
    @GetMapping("{id}")
    public CategoryResponse getCategoryById(@PathVariable Long id) {
        return mCategoryService.getCategory(id);
    }
}