package escuelaing.ieti.lab2p1.service;

import escuelaing.ieti.lab2p1.entities.User;

import java.util.List;

public interface UserService {

    User create(User user);
    User findById(int id);
    List<User> getAll();
    void deleteById(int id);
    User update(User user, int id);

}
