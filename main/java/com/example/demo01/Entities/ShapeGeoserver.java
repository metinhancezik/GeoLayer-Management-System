package com.example.demo01.Entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Geometry;

import java.math.BigDecimal;




@Getter
@Setter
@Entity
@Table(name="shapegeoserver")
public class ShapeGeoserver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fid")
    private Long id;

    @Column(name = "shapeinfo", columnDefinition = "Geometry")
    private Geometry geometry;

    @Column(name = "shapename")
    private String shapename;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
