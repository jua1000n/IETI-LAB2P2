package escuelaing.ieti.lab2p2.controller;

import escuelaing.ieti.lab2p2.dto.TaskDTO;
import escuelaing.ieti.lab2p2.entities.Task;
import escuelaing.ieti.lab2p2.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin
@RestController
@RequestMapping("/v1/task")
public class TaskController {

    @Autowired
    private TaskService taskService;
    private final AtomicLong counter = new AtomicLong(0);

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAll() {
        try {
            return new ResponseEntity<>(taskService.getAll(), HttpStatus.ACCEPTED);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<Task> findById(@PathVariable int id ) {
        try {
            return new ResponseEntity<>(taskService.findById(id), HttpStatus.ACCEPTED);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody TaskDTO taskDTO) {
        try{
            Task task = new Task();
            task.setId((int) counter.incrementAndGet());
            task.setName(taskDTO.getName());
            task.setDescription(taskDTO.getDescription());
            task.setStatus(taskDTO.getStatus());
            task.setAssignedTo(taskDTO.getAssignedTo());
            task.setDueDate(taskDTO.getDueDate());
            task.setCreatedAt(taskDTO.getCreatedAt());
            return new ResponseEntity<>(taskService.create(task) ,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<Task> update(@RequestBody TaskDTO taskDTO, @PathVariable int id) {
        try{
            Task task = new Task();
            task.setName(taskDTO.getName());
            task.setDescription(taskDTO.getDescription());
            task.setStatus(taskDTO.getStatus());
            task.setAssignedTo(taskDTO.getAssignedTo());
            task.setDueDate(taskDTO.getDueDate());
            task.setCreatedAt(taskDTO.getCreatedAt());
            return new ResponseEntity<>(taskService.update(task, id), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        try{
            taskService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}