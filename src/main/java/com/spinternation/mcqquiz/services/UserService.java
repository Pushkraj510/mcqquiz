package com.spinternation.mcqquiz.services;

import com.spinternation.mcqquiz.request.UserRequest;
import com.spinternation.mcqquiz.response.GeneralResponse;
import com.spinternation.mcqquiz.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserResponse> getAllUsers();
    UserResponse getUserById(Long id);
    UserResponse saveUser(UserRequest userRequest);
    GeneralResponse deleteUserById(Long id);
}
