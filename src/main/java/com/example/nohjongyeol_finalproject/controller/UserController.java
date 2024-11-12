package com.example.nohjongyeol_finalproject.controller;


import com.example.nohjongyeol_finalproject.dao.UserDao;
import com.example.nohjongyeol_finalproject.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserDao userDao = new UserDao();

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestParam String name,
                                                @RequestParam String email) {
        User user = userDao.registerUser(name, email);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<User[]> getAllUsers() {
        User[] users = userDao.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/update")
    public ResponseEntity<User> updateUser(@RequestParam Long id,
                                           @RequestParam String name,
                                           @RequestParam String email) {
        User user = userDao.updateUser(id, name, email);
        return ResponseEntity.ok(user);
    }
}
