package am.itspace.listing_app.service;

import am.itspace.listing_app.exception.CategoryNotFoundException;
import am.itspace.listing_app.model.Category;
import am.itspace.listing_app.model.User;
import am.itspace.listing_app.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(int id) {
        return categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public Category update(Category category, int id) {
        Category categoryFromDb = categoryRepository.findById(id).orElseThrow(() -> new ResolutionException("Category does not exists"));
        categoryFromDb.setName(category.getName());
        return categoryRepository.save(categoryFromDb);
    }

    public void deleteById(int id){
        categoryRepository.deleteById(id);
    }

}
