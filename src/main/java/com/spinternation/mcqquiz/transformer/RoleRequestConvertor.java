package com.spinternation.mcqquiz.transformer;

import com.spinternation.mcqquiz.entity.Role;
import com.spinternation.mcqquiz.request.RoleRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleRequestConvertor {
    public Role toRoleEntity(RoleRequest request) {
        Role role = new Role();
        role.setId(request.getId());
        role.setName(request.getName());
        return role;
    }

    public List<Role> toRoleEntityList(List<RoleRequest> requestList) {
        return requestList.stream().map(this::toRoleEntity).collect(Collectors.toList());
    }
}
