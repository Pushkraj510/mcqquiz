package com.spinternation.mcqquiz.services.implementation;

import com.spinternation.mcqquiz.entity.Role;
import com.spinternation.mcqquiz.repository.RoleRepository;
import com.spinternation.mcqquiz.request.RoleRequest;
import com.spinternation.mcqquiz.response.GeneralResponse;
import com.spinternation.mcqquiz.response.RoleResponse;
import com.spinternation.mcqquiz.services.RoleService;
import com.spinternation.mcqquiz.transformer.RoleRequestConvertor;
import com.spinternation.mcqquiz.transformer.RoleResponseConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleRequestConvertor roleRequestConvertor;
    @Autowired
    private RoleResponseConvertor roleResponseConvertor;

    @Override
    public List<RoleResponse> getAllRoles() {
        return roleResponseConvertor.toRoleResponseList(roleRepository.findAllByIsDeleted(Boolean.FALSE));
    }

    @Override
    public RoleResponse getRoleById(Integer id) {
        final Role role = roleRepository.findByIdAndIsDeleted(id,Boolean.FALSE).orElseThrow(() -> new RuntimeException("Role not found"));
        return roleResponseConvertor.toRoleResponse(role);
    }

    @Override
    public RoleResponse saveRole(RoleRequest roleRequest) {
        final Role role = roleRequestConvertor.toRoleEntity(roleRequest);
        final Role savedRole = roleRepository.save(role);
        return roleResponseConvertor.toRoleResponse(savedRole);
    }

    @Override
    public GeneralResponse deleteRoleById(Integer id) {
        Role role = roleRepository.findByIdAndIsDeleted(id,Boolean.FALSE).orElseThrow(() -> new RuntimeException("Role not found"));
        role.setIsDeleted(Boolean.TRUE);
        roleRepository.save(role);
        return new GeneralResponse("Role deleted successfully", HttpStatus.OK.value());
    }
}
