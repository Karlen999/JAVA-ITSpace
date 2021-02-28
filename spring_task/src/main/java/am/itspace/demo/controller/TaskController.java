package am.itspace.demo.controller;

import am.itspace.demo.model.Task;
import am.itspace.demo.repository.MemberRepository;
import am.itspace.demo.repository.TaskRepository;
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

    private final TaskRepository taskRepository;
    private final MemberRepository memberRepository;

    @GetMapping("/task/save")
    public String saveTask(@RequestParam(value = "id", required = false) Integer id, ModelMap modelMap){

        if (id != null){
            modelMap.addAttribute("task", taskRepository.getOne(id));
        }else {
            modelMap.addAttribute("task", new Task());
        }
        modelMap.addAttribute("members", memberRepository.findAll());
        return "saveTask";
    }

    @PostMapping("/task/save")
    public String addTask(@ModelAttribute Task task){
        taskRepository.save(task);
        return "redirect:/";
    }

    @GetMapping("/task/delete")
    public String deleteTask(@RequestParam("id") int id){
        taskRepository.deleteById(id);
        return "redirect:/";
    }
}
