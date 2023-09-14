package com.alexkozlov.testTask.service;

import com.alexkozlov.testTask.exceprtion.UserExistingEmailException;
import com.alexkozlov.testTask.exceprtion.UserNotFoundException;
import com.alexkozlov.testTask.model.Users;
import com.alexkozlov.testTask.repo.UserRepo;
import com.alexkozlov.testTask.response.ResponseHandler;
import com.sun.xml.internal.ws.client.sei.ResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    UserRepo userRepo;

    public ResponseEntity<Object> saveUser(Users user) {
        if (user.getEmail().equals(userRepo.findByEmail(user.getEmail()).get().getEmail())) {

            throw new UserExistingEmailException("There is user with same email");

        }

            long id = userRepo.save(user).getId();
            return ResponseHandler.responseBuilder("user saved", HttpStatus.OK, id );

    }



    @Override
    public ResponseEntity<Object> getById(long id) {
        if(!userRepo.findById(id).isPresent()){
            throw new UserNotFoundException("User does not exist");
        }
        return ResponseHandler.responseBuilder("serched user", HttpStatus.OK, userRepo.findById(id).get());


    }

    @Override
    public ResponseEntity<Object> updateUser(long id) {

        if(!userRepo.findById(id).isPresent()){
            throw new UserNotFoundException("User does not exist");
        }
        
      Users user =  userRepo.findById(id).get();
      Map<String, String> updateResponse = new HashMap<>();

      updateResponse.put("id", "" + user.getId());
      updateResponse.put("previousStatus", user.getStatus());

      if (user.getStatus().equalsIgnoreCase("offLine")) {
          user.setStatus("onLine");
          updateResponse.put("currentStatus", user.getStatus());
      } else {
          user.setStatus("offLine");
          updateResponse.put("currentStatus", user.getStatus());
      }

      userRepo.save(user);
      return ResponseHandler.responseBuilder("user was updated", HttpStatus.OK, updateResponse);

    }
}
