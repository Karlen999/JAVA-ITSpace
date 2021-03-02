package am.itspace.demo.controller;

import am.itspace.demo.model.Author;
import am.itspace.demo.repository.AuthorRepository;
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
public class AuthorController {

    private final AuthorRepository authorRepository;

    @GetMapping("authors/all")
    public String getAllAuthors(ModelMap modelMap){
        List<Author> authors = authorRepository.findAll();
        modelMap.addAttribute("authors", authors);
        return "authorPage";
    }

    @GetMapping("/author/update")
    public String updateAuthor(@RequestParam(value = "id", required = false) Integer id, ModelMap modelMap){
        if (id != null){
            modelMap.addAttribute("author",authorRepository.getOne(id));
        }else{
            modelMap.addAttribute("author", new Author());
        }
        return "updateAuthor";
    }

    @PostMapping("/author/update")
    public String add(@ModelAttribute Author author){
        authorRepository.save(author);
        return "redirect:/";
    }


    @GetMapping("/author/delete")
    public String deleteAuthor(@RequestParam("id") int id){
        authorRepository.deleteById(id);
        return "redirect:/authors/all";
    }
}
