package escuelaing.ieti.lab2p2.repository;

import escuelaing.ieti.lab2p2.entities.Task;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

@Document
public interface TaskRepository extends MongoRepository<Task, Integer> {
}
