package com.example.demo01.Interfaces;


import com.example.demo01.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInterface extends JpaRepository<User, Long> {

    Optional<User> findByusername(String username);
    Optional<User> findByuserid(Long userid);

    Optional<User> findBystatus(String status);

}
