package com.spinternation.mcqquiz.controller;

import com.spinternation.mcqquiz.entity.Role;
import com.spinternation.mcqquiz.request.RoleRequest;
import com.spinternation.mcqquiz.response.GeneralResponse;
import com.spinternation.mcqquiz.response.RoleResponse;
import com.spinternation.mcqquiz.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<List<RoleResponse>> getAllRoles(){
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponse> getRoleById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(roleService.getRoleById(id));
    }

    @PostMapping
    public ResponseEntity<RoleResponse> saveRole(@RequestBody RoleRequest roleRequest){
        roleRequest.setId(0);
        return ResponseEntity.ok(roleService.saveRole(roleRequest));
    }

    @PutMapping
    public ResponseEntity<RoleResponse> updateRole(@RequestBody RoleRequest roleRequest){
        return ResponseEntity.ok(roleService.saveRole(roleRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GeneralResponse> deleteRoleById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(roleService.deleteRoleById(id));
    }
}
