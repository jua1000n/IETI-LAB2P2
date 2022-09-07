package escuelaing.ieti.lab2p2.service.impl;

import escuelaing.ieti.lab2p2.entities.Task;
import escuelaing.ieti.lab2p2.repository.TaskRepository;
import escuelaing.ieti.lab2p2.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task create(Task task) {
        taskRepository.save(task);
        return findById(task.getId());
    }

    @Override
    public Task findById(int id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task update(Task task, int id) throws Exception {
        if(findById(id) == null) {
            throw new Exception("El usuario no existe");
        }
        deleteById(id);
        task.setId(id);
        return create(task);

    }
}