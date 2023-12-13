package com.spinternation.mcqquiz.transformer;

import com.spinternation.mcqquiz.entity.User;
import com.spinternation.mcqquiz.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserRequestConvertor {
    @Autowired
    private RoleRequestConvertor roleRequestConvertor;
    public User toUserEntity(UserRequest request)
    {
        User user = new User();
        user.setId(request.getId());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setUserName(request.getUserName());
        user.setPassword(request.getPassword());
        user.setMobileNumber(request.getMobileNumber());
        user.setRole(roleRequestConvertor.toRoleEntity(request.getRoleRequest()));
        return user;
    }

    public List<User> toUserEntityList(List<UserRequest> requestList)
    {
        return requestList.stream().map(this::toUserEntity).collect(Collectors.toList());
    }
}
