package am.itspace.listing_app.repository;

import am.itspace.listing_app.model.Category;
import am.itspace.listing_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findById(int id);

}
