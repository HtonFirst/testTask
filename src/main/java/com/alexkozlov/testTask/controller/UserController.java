package com.alexkozlov.testTask.controller;

import com.alexkozlov.testTask.model.Users;
import com.alexkozlov.testTask.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable long id) {
        return service.getById(id);

    }


    @PostMapping
    public ResponseEntity<Object> addUser(@RequestBody Users user) {
     return    service.saveUser(user);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUserStatus(@PathVariable String id) {
      return   service.updateUser(Long.parseLong(id));
    }

}
