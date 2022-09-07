package escuelaing.ieti.lab2p2.service;

import escuelaing.ieti.lab2p2.entities.Task;

import java.util.List;

public interface TaskService {

    Task create(Task task);
    Task findById(int id);
    List<Task> getAll();
    void deleteById(int id);
    Task update(Task task, int id) throws Exception;

}
