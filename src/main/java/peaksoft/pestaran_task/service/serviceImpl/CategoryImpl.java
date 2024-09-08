package peaksoft.pestaran_task.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.pestaran_task.dto.SimpleResponse;
import peaksoft.pestaran_task.dto.category.CategoryRequest;
import peaksoft.pestaran_task.dto.category.CategoryResponse;
import peaksoft.pestaran_task.entiti.Category;
import peaksoft.pestaran_task.entiti.Restaurant;
import peaksoft.pestaran_task.entiti.Subcategory;
import peaksoft.pestaran_task.repository.CategoryRepository;
import peaksoft.pestaran_task.repository.SubcategoryRepository;
import peaksoft.pestaran_task.service.CategoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CategoryImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final SubcategoryRepository subcategoryRepository;

    @Override
    public CategoryResponse getCategory(Long id) {
         Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Ресторан табылган жок, ID: " + id));
         CategoryResponse categoryResponse = new CategoryResponse();
         categoryResponse.setName(category.getName());
         return categoryResponse;
    }

    @Override
    public List<CategoryResponse> getCategories(){
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponse> categoriesResponse = new ArrayList<>();

        for (Category category : categories) {
            categoriesResponse.add(CategoryResponse.builder()
                    .name(category.getName())
                    .build());
        }

        return categoriesResponse;
    }

    @Override
    public SimpleResponse saveCategory(CategoryRequest category1) {
        try {
            Category category= new Category();
            category.setName(category1.getName());
            categoryRepository.save(category);
            return new SimpleResponse(
                    HttpStatus.OK,
                    "Категория сакталды"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return new SimpleResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Категория сактоо учурунда ката болду"
            );
        }
    }

    @Override
    public SimpleResponse deleteCategory(Long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Ресторан табылган жок, ID: " + id));
        categoryRepository.delete(category);
        return  new  SimpleResponse(
                HttpStatus.OK,
                "очту"
        );
    }

    @Override
    public SimpleResponse updateCategory( Long id,CategoryRequest category) {
        Category category1 = categoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Ресторан табылган жок, ID: " + id));
        category1.setName(category.getName());
        categoryRepository.save(category1);
        return  new  SimpleResponse(
                HttpStatus.OK,
                "сакталды"
        );
    }
}