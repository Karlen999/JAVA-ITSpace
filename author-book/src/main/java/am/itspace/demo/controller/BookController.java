package am.itspace.demo.controller;

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
public class BookController {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @GetMapping("/books/all")
    public String getAllBooks(ModelMap modelMap){
        List<Book> books = bookRepository.findAll();
        modelMap.addAttribute("books",books);
        return "bookPage";
    }
    @GetMapping("/book/update")
    public String saveBook(@RequestParam(value = "id", required = false) Integer id, ModelMap modelMap){
        if (id != null){
            modelMap.addAttribute("book", bookRepository.getOne(id));
        }else {
            modelMap.addAttribute("book", new Book());
        }
        modelMap.addAttribute("authors", authorRepository.findAll());
        return "updateBook";
    }

    @PostMapping("/book/update")
    public String addBook(@ModelAttribute Book book){
        bookRepository.save(book);
        return "redirect:/";
    }

    @GetMapping("/book/delete")
    public String deleteBook(@RequestParam("id") int id){
        bookRepository.deleteById(id);
        return "redirect:/books/all";
    }
}
