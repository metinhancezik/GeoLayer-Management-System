package com.example.demo01.Interfaces;

import com.example.demo01.Entities.Shape;
import com.example.demo01.Entities.ShapeGeoserver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ShapeGeoserverInterface extends JpaRepository<ShapeGeoserver,Long> {

    List<ShapeGeoserver> findByUser_Id(Long userId);
}
