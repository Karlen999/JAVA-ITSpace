package am.itspace.listing_app.endpoint;

import am.itspace.listing_app.exception.CategoryNotFoundException;
import am.itspace.listing_app.exception.UserNotFoundException;
import am.itspace.listing_app.model.Category;
import am.itspace.listing_app.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    
    private final CategoryService categoryService;
    
    @GetMapping
    public List<Category> categories(){
        return categoryService.findAll();
    }
    
    @GetMapping("{id}")
    public ResponseEntity category(@PathVariable("id") int id){
        try {
            return ResponseEntity.ok(categoryService.findById(id));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Category category){
        if (category.getId() > 0){
            throw new RuntimeException("Id must be 0");
        }
        categoryService.save(category);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody Category category, @PathVariable("id") int id ){
        categoryService.update(category, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        try {
            categoryService.findById(id);
        }catch (CategoryNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        categoryService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
