package com.example.demo01.Services;

import com.example.demo01.Entities.MahalleEntity;
import com.example.demo01.Entities.Shape;
import com.example.demo01.Entities.User;
import com.example.demo01.Interfaces.ShapeInterface;
import com.example.demo01.Interfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ShapeService {

    private final ShapeInterface shapeRepository;
    private final UserInterface userRepository; // UserRepository ekleniyor.

    @Autowired
    public ShapeService(ShapeInterface shapeRepository, UserInterface userRepository) {
        this.shapeRepository = shapeRepository;
        this.userRepository = userRepository;
    }

    public List<Shape> findByUser_Id(Long userId) {
        return shapeRepository.findByUser_Id(userId);
    }

    Long userID;
    public Shape saveShape(Shape shape, Long userId) {
        userID=userId;
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        shape.setUser(user); // Shape'e user atanıyor.
        return shapeRepository.save(shape);
    }

    public List<Shape> ShapeDataBring(Long userId) {
        return shapeRepository.findByUser_Id(userId);
    }


}
