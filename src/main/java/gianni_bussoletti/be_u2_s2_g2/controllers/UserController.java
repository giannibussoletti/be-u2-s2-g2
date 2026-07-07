package gianni_bussoletti.be_u2_s2_g2.controllers;

import gianni_bussoletti.be_u2_s2_g2.entities.User;
import gianni_bussoletti.be_u2_s2_g2.payloads.UserPayload;
import gianni_bussoletti.be_u2_s2_g2.services.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }
    //    1. GET http://localhost:5555/users --> 200 Ok, array di utenti

    @GetMapping
    public List<User> getAllUser() {
        return this.usersService.findAll();
    }

    //    2. POST http://localhost:5555/users (+ payload) -->201 con utente appena creato o solo id
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // <-- Questo imposta lo status code con 201
    public User createUser(@RequestBody UserPayload payload) {
        return this.usersService.createUser(payload);
    }

    //    3. GET http://localhost:5555/users/{userId} 200 OK - con utente trovato (404 se non lo trovo)
    @GetMapping("/{userId}")
    public User findById(@PathVariable long userId) {
        return this.usersService.findById(userId);

    }

    //    4. PUT http://localhost:5555/users/{userId} + payload --> 200 OK - con utente aggiornato
    @PutMapping("/{userId}")
    public User findByIdAndUpdate(@PathVariable long userId, @RequestBody UserPayload userPayload) {
        return this.usersService.findByIdAndUpdate(userId, userPayload);
    }

    //    5. DELETE http://localhost:5555/users/{userID} --> 204 NO CONTENT
    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable long userId) {
        this.usersService.findByIdAndDelete(userId);
    }
}
