package com.spinternation.mcqquiz.controller;

import com.spinternation.mcqquiz.request.UserRequest;
import com.spinternation.mcqquiz.response.GeneralResponse;
import com.spinternation.mcqquiz.response.UserResponse;
import com.spinternation.mcqquiz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponse> saveUser(@RequestBody UserRequest userRequest){
        userRequest.setId(0L);
        return ResponseEntity.ok(userService.saveUser(userRequest));
    }

    @PutMapping
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(userService.saveUser(userRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GeneralResponse> deleteUserById(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.deleteUserById(id));
    }
}
