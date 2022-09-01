package escuelaing.ieti.lab2p2.service.impl;

import escuelaing.ieti.lab2p2.entities.Task;
import escuelaing.ieti.lab2p2.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TaskImpl implements TaskService {

    private final ConcurrentHashMap<Integer, Task> tasks = new ConcurrentHashMap<Integer, Task>();

    @Override
    public Task create(Task task) {
        return tasks.put(task.getId(), task);
    }

    @Override
    public Task findById(int id) {
        return tasks.get(id);
    }

    @Override
    public List<Task> getAll() {
        List<Task> request = new ArrayList<>();
        for (Integer key: tasks.keySet()) {
            request.add(tasks.get(key));
        }
        return request;
    }

    @Override
    public void deleteById(int id) {
        tasks.remove(id);
    }

    @Override
    public Task update(Task user, int id) {
        tasks.remove(id);
        return tasks.put(id, user);
    }
}