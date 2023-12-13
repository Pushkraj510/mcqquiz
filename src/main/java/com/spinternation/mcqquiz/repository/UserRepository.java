package com.spinternation.mcqquiz.repository;

import com.spinternation.mcqquiz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserNameAndIsDeleted(String userName, Boolean isDeleted);
    Optional<User> findByIdAndIsDeleted(Long id, Boolean isDeleted);
    List<User> findAllByIsDeleted(Boolean isDeleted);
}
