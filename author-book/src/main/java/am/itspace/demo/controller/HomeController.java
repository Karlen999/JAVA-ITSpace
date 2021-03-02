package am.itspace.demo.controller;

import am.itspace.demo.model.Author;
import am.itspace.demo.model.Book;
import am.itspace.demo.repository.AuthorRepository;
import am.itspace.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @GetMapping("/")
    public String homePage(ModelMap modelMap) {
        List<Author> authorsList = authorRepository.findAll();
        List<Book> booksList = bookRepository.findAll();
        modelMap.addAttribute("authors",authorsList);
        modelMap.addAttribute("books", booksList);
        return ("home");
    }

    @PostMapping("/author/add")
    public String addAuthor(@ModelAttribute Author author){
        authorRepository.save(author);
        return "redirect:/";
    }

    @PostMapping("/book/add")
    public String addBook(@ModelAttribute Book book){
        bookRepository.save(book);
        return "redirect:/";
    }

}
