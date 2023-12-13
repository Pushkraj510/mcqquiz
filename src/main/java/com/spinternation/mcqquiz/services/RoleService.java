package com.spinternation.mcqquiz.services;

import com.spinternation.mcqquiz.request.RoleRequest;
import com.spinternation.mcqquiz.response.GeneralResponse;
import com.spinternation.mcqquiz.response.RoleResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    List<RoleResponse> getAllRoles();
    RoleResponse getRoleById(Integer id);
    RoleResponse saveRole(RoleRequest roleRequest);
    GeneralResponse deleteRoleById(Integer id);
}
