package com.alexkozlov.testTask.service;

import com.alexkozlov.testTask.model.Users;
import com.alexkozlov.testTask.response.ResponseHandler;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {

    ResponseEntity<Object> saveUser(Users user);

    ResponseEntity<Object> getById(long id);
    ResponseEntity<Object> updateUser(long id);
}
