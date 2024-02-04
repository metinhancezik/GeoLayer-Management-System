package com.example.demo01.Entities;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "shapes")
public class Shape {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shape_data", nullable = false, columnDefinition = "TEXT")
    private String shapeData;

    @Column(name = "nameOfShapes")
    private String shapeNames;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Shape() {}

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getShapeData() {
        return shapeData;
    }

    public void setShapeData(String shapeData) {
        this.shapeData = shapeData;
    }
    public String getShapeName() {
        return shapeNames;
    }

    public void setShapeName(String shapeName) {
        this.shapeNames = shapeName;
    }
}

