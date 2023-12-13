package com.spinternation.mcqquiz.transformer;

import com.spinternation.mcqquiz.entity.Role;
import com.spinternation.mcqquiz.response.RoleResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleResponseConvertor {
    public RoleResponse toRoleResponse(Role role) {
        RoleResponse roleResponse = new RoleResponse();
        roleResponse.setId(role.getId());
        roleResponse.setName(role.getName());
        return roleResponse;
    }

    public List<RoleResponse> toRoleResponseList(List<Role> roleList) {
        return roleList.stream().map(this::toRoleResponse).collect(Collectors.toList());
    }
}
