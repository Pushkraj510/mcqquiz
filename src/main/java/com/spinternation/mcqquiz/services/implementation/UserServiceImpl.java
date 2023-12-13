package com.spinternation.mcqquiz.services.implementation;

import com.spinternation.mcqquiz.entity.User;
import com.spinternation.mcqquiz.repository.UserRepository;
import com.spinternation.mcqquiz.request.UserRequest;
import com.spinternation.mcqquiz.response.GeneralResponse;
import com.spinternation.mcqquiz.response.UserResponse;
import com.spinternation.mcqquiz.services.UserService;
import com.spinternation.mcqquiz.transformer.UserRequestConvertor;
import com.spinternation.mcqquiz.transformer.UserResponseConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRequestConvertor userRequestConvertor;
    @Autowired
    private UserResponseConvertor userResponseConvertor;
    @Override
    public List<UserResponse> getAllUsers() {
        return userResponseConvertor.toUserResponseList(userRepository.findAllByIsDeleted(Boolean.FALSE));
    }

    @Override
    public UserResponse getUserById(Long id) {
        final User user = userRepository.findByIdAndIsDeleted(id, Boolean.FALSE).orElseThrow(() -> new RuntimeException("User not found"));
        return userResponseConvertor.toUserResponse(user);
    }

    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        final User user = userRequestConvertor.toUserEntity(userRequest);
        final User savedUser = userRepository.save(user);
        return userResponseConvertor.toUserResponse(savedUser);
    }

    @Override
    public GeneralResponse deleteUserById(Long id) {
        final User user = userRepository.findByIdAndIsDeleted(id, Boolean.FALSE).orElseThrow(() -> new RuntimeException("User not found"));
        user.setIsDeleted(Boolean.TRUE);
        userRepository.save(user);
        return new GeneralResponse("User deleted successfully", HttpStatus.OK.value());
    }
}
