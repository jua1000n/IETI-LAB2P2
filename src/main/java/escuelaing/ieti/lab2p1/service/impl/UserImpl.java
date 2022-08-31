package escuelaing.ieti.lab2p1.service.impl;

import escuelaing.ieti.lab2p1.entities.User;
import escuelaing.ieti.lab2p1.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserImpl implements UserService {

    private final ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<Integer, User>();

    @Override
    public User create(User user) {
        users.put(user.getId(), user);
        return users.get(user.getId());
    }

    @Override
    public User findById(int id) {
        return users.get(id);
    }

    @Override
    public List<User> getAll() {
        List<User> request = new ArrayList<>();
        for (Integer key: users.keySet()) {
            request.add(users.get(key));
        }
        return request;
    }

    @Override
    public void deleteById(int id) {
        users.remove(id);
    }

    @Override
    public User update(User user, int id) {
        users.remove(id);
        return users.put(id, user);
    }
}