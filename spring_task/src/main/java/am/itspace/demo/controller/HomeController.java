package am.itspace.demo.controller;

import am.itspace.demo.model.Task;
import am.itspace.demo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final TaskRepository taskRepository;

    @GetMapping("/")
    public String homePage(ModelMap modelMap){
        List<Task> all = taskRepository.findAll();
        modelMap.addAttribute("tasks", all);
        return "home";
    }

    @GetMapping("/search")
    public String search(@RequestParam("keyword") String keyword, ModelMap modelMap){
        if (keyword == null || keyword.length() ==0){
            return "redirect:/";
        }
        List<Task> allByName = taskRepository.findAllByNameStartingWith(keyword);
        modelMap.addAttribute("tasks", allByName);
        return "home";
    }
}
