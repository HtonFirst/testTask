package com.alexkozlov.testTask.response;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {


    public static ResponseEntity<Object> responseBuilder(String message, HttpStatus httpStatus, Object responseObject) {
        Map<String, Object> response = new HashMap<>();

        response.put("data", responseObject);
        response.put("message", message);
        response.put("HttpStatus", httpStatus);

        return new ResponseEntity<>(response, httpStatus);
    }
}
