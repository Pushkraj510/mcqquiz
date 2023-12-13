package com.spinternation.mcqquiz.repository;

import com.spinternation.mcqquiz.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
    List<Role> findAllByIsDeleted(Boolean isDeleted);
    Optional<Role> findByIdAndIsDeleted(Integer id, Boolean isDeleted);
}
