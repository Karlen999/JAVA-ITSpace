package am.itspace.demo.service;

import am.itspace.demo.model.Task;

import java.util.List;

public interface TaskService {

    void saveTask (Task task);

    List<Task> findAll();

    Task getTask(int id);

    void deleteTask(int id);
}
