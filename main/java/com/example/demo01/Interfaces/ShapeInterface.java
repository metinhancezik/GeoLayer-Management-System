package com.example.demo01.Interfaces;

import com.example.demo01.Entities.Shape;
import com.example.demo01.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShapeInterface extends JpaRepository<Shape,Long> {
    List<Shape> findByUser_Id(Long userId);
}
