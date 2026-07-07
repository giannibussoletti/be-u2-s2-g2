package gianni_bussoletti.be_u2_s2_g2.services;

import gianni_bussoletti.be_u2_s2_g2.entities.User;
import gianni_bussoletti.be_u2_s2_g2.exceptions.NotFoundException;
import gianni_bussoletti.be_u2_s2_g2.payloads.UserPayload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {
    private final List<User> usersDB = new ArrayList<>();


    public List<User> findAll() {
        return this.usersDB;
    }

    public User createUser(UserPayload payload) {
        User newUser = new User(payload.getName(), payload.getSurname(), payload.getEmail(), payload.getPassword());
        this.usersDB.add(newUser);
        return newUser;
    }

    public User findById(long userId) {
        User found = null;

        for (User user : this.usersDB) {
            if (user.getId() == userId) found = user;
        }

        if (found == null) throw new NotFoundException(userId);

        return found;
    }

    public User findByIdAndUpdate(long userId, UserPayload body) {
        User found = null;

        for (User user : this.usersDB) {
            if (user.getId() == userId) {
                found = user;
                found.setName(body.getName());
                found.setSurname(body.getSurname());
                found.setEmail(body.getEmail());
                found.setPassword(body.getPassword());
            }
        }

        if (found == null) throw new NotFoundException(userId);

        return found;
    }

    public void findByIdAndDelete(long userId) {
        User found = null;

        for (User user : this.usersDB) {
            if (user.getId() == userId) found = user;
        }

        if (found == null) throw new NotFoundException(userId);

        this.usersDB.remove(found);
    }
}
