package com.spinternation.mcqquiz.transformer;

import com.spinternation.mcqquiz.entity.User;
import com.spinternation.mcqquiz.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserResponseConvertor {

    @Autowired
    private RoleResponseConvertor roleResponseConvertor;
    public UserResponse toUserResponse(User userEntity) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(userEntity.getId());
        userResponse.setFirstName(userEntity.getFirstName());
        userResponse.setLastName(userEntity.getLastName());
        userResponse.setEmail(userEntity.getEmail());
        userResponse.setUserName(userEntity.getUserName());
        userResponse.setPassword(userEntity.getPassword());
        userResponse.setMobileNumber(userEntity.getMobileNumber());
        userResponse.setRoleResponse(roleResponseConvertor.toRoleResponse(userEntity.getRole()));
        return userResponse;
    }

    public List<UserResponse> toUserResponseList(List<User> userEntityList) {
        return userEntityList.stream().map(this::toUserResponse).collect(Collectors.toList());
    }
}
