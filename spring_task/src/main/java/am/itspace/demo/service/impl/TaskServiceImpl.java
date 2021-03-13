package am.itspace.demo.service.impl;

import am.itspace.demo.model.Task;
import am.itspace.demo.repository.MemberRepository;
import am.itspace.demo.repository.TaskRepository;
import am.itspace.demo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final MemberRepository memberRepository;

    @Override
    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTask(int id) {
        return taskRepository.getOne(id);
    }

    @Override
    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }
}
