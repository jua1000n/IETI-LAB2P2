package escuelaing.ieti.lab2p1.controller;

import escuelaing.ieti.lab2p1.dto.UserDTO;
import escuelaing.ieti.lab2p1.entities.User;
import escuelaing.ieti.lab2p1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserService userService;
    private final AtomicLong counter = new AtomicLong(0);

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAll() {
        try {
            return new ResponseEntity<>(userService.getAll(), HttpStatus.ACCEPTED);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<User> findById( @PathVariable int id ) {
        try {
            return new ResponseEntity<>(userService.findById(id), HttpStatus.ACCEPTED);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDTO userDTO) {
        try{
            User user = new User();
            user.setId((int) counter.incrementAndGet());
            user.setEmail(userDTO.getEmail());
            user.setName(userDTO.getName());
            user.setLastName(userDTO.getLastName());
            user.setCreatedAt(userDTO.getCreatedAt());
            return new ResponseEntity<>(userService.create(user) ,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody UserDTO userDTO, @PathVariable int id) {
        try{
            User user = userService.findById(id);
            user.setEmail(userDTO.getEmail());
            user.setName(userDTO.getName());
            user.setLastName(userDTO.getLastName());
            user.setCreatedAt(userDTO.getCreatedAt());
            userService.update(user, id);
            return new ResponseEntity<>(userService.update(user, id), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        try{
            userService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}