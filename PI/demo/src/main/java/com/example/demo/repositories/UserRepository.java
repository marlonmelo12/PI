package com.example.demo.repositories;

import com.example.demo.entity.User;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    @Query("SELECT u FROM TB_user u ORDER BY u.amount DESC")
    List<User> rank();
    
    Optional<User> findByLogin(String login);
    Optional<User> findById(String id);
}
