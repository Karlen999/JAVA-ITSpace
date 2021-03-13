package am.itspace.demo.controller;

import am.itspace.demo.model.Task;
import am.itspace.demo.repository.MemberRepository;
import am.itspace.demo.repository.TaskRepository;
import am.itspace.demo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/task/save")
    public String saveTask(@RequestParam(value = "id", required = false) Integer id, ModelMap modelMap){

        if (id != null){
            modelMap.addAttribute("task", taskService.getTask(id));
        }else {
            modelMap.addAttribute("task", new Task());
        }
        modelMap.addAttribute("members", taskService.findAll());
        return "saveTask";
    }

    @PostMapping("/task/save")
    public String addTask(@ModelAttribute Task task){
        taskService.saveTask(task);
        return "redirect:/";
    }

    @GetMapping("/task/delete")
    public String deleteTask(@RequestParam("id") int id){
        taskService.deleteTask(id);
        return "redirect:/";
    }
}
