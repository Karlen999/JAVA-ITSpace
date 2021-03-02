package am.itspace.demo.repository;

import am.itspace.demo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findAllByNameStartingWith(String name);
}
