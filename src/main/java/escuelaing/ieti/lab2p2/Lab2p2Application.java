package escuelaing.ieti.lab2p2;

import escuelaing.ieti.lab2p2.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class Lab2p2Application {

	@Autowired
	TaskRepository taskRepository;
	public static void main(String[] args) {
		SpringApplication.run(Lab2p2Application.class, args);
	}

}
