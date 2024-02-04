package com.example.demo01.Services;

import com.example.demo01.DTOs.RootDTO;
import com.example.demo01.DTOs.ShapeDataDTO;
import com.example.demo01.DTOs.ShapeDataPolylineDTO;
import com.example.demo01.Entities.ShapeGeoserver;
import com.example.demo01.Entities.User;
import com.example.demo01.Interfaces.ShapeGeoserverInterface;
import com.example.demo01.Interfaces.UserInterface;
import org.locationtech.jts.geom.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ShapeGeoserverService {

    private final ShapeGeoserverInterface shapeGeoserverRepository;
    private final UserInterface userRepository; // UserRepository ekleniyor.
    private final ShapeGeoserverInterface shapeGeoserverInterface; // UserRepository ekleniyor.

    @Autowired
    public ShapeGeoserverService(ShapeGeoserverInterface shapeGeoserverRepository, UserInterface userRepository, ShapeGeoserverInterface shapeGeoserverInterface) {
        this.shapeGeoserverRepository = shapeGeoserverRepository;
        this.userRepository = userRepository;
        this.shapeGeoserverInterface = shapeGeoserverInterface;
    }




    public List<ShapeGeoserver> ShapeDataBring(Long userId) {
        return shapeGeoserverInterface.findByUser_Id(userId);
    }













    /*public ShapeGeoserver saveShape(ShapeDataDTO shapeDataDTO, Long userId,String shapeName) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);

        ShapeGeoserver shapeGeoserver = new ShapeGeoserver();
        shapeGeoserver.setUser(user);
        shapeGeoserver.setShapename(shapeName);

        for (ShapeDataDTO.ShapeElement shapeElement : shapeDataDTO.getShapeData()) {
            Geometry geometry;
            if ("polygon".equals(shapeElement.getType())) {
                Coordinate[] coordinates = shapeElement.getCoordinates().get(0).stream()
                        .map(coord -> new org.locationtech.jts.geom.Coordinate(coord.getLng(), coord.getLat()))
                        .toArray(org.locationtech.jts.geom.Coordinate[]::new);
                geometry = geometryFactory.createPolygon(coordinates);
            } else if ("polyline".equals(shapeElement.getType())) {
                Coordinate[] coordinates = shapeElement.getCoordinates().get(0).stream()
                        .map(coord -> new org.locationtech.jts.geom.Coordinate(coord.getLng(), coord.getLat()))
                        .toArray(org.locationtech.jts.geom.Coordinate[]::new);
                geometry = geometryFactory.createLineString(coordinates);
            } else if ("marker".equals(shapeElement.getType()) || "circlemarker".equals(shapeElement.getType())) {
                ShapeDataDTO.Coordinate dtoCoord = shapeElement.getCenter();
                org.locationtech.jts.geom.Coordinate coordinate = new org.locationtech.jts.geom.Coordinate(dtoCoord.getLng(), dtoCoord.getLat());
                geometry = geometryFactory.createPoint(coordinate);
            } else {
                throw new IllegalArgumentException("Unknown shape type: " + shapeElement.getType());
            }

            shapeGeoserver.setGeometry(geometry);

            shapeGeoserverRepository.save(shapeGeoserver);
        }

        return shapeGeoserver;
    }*/

    public ShapeGeoserver saveShape(ShapeDataDTO shapeDataDTO, Long userId, String shapeName) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);

        ShapeGeoserver shapeGeoserver = new ShapeGeoserver();
        shapeGeoserver.setUser(user);
        shapeGeoserver.setShapename(shapeName);

        ArrayList<Geometry> geometries = new ArrayList<>();

        for (ShapeDataDTO.ShapeElement shapeElement : shapeDataDTO.getShapeData()) {
            Geometry geometry;
            if ("polygon".equals(shapeElement.getType())) {
                List<org.locationtech.jts.geom.Coordinate> coordinatesList = shapeElement.getCoordinates().get(0).stream()
                        .map(coord -> new org.locationtech.jts.geom.Coordinate(coord.getLng(), coord.getLat()))
                        .collect(Collectors.toList());

                // Poligonun başlangıç noktasını sona ekliyoruz.
                coordinatesList.add(coordinatesList.get(0));

                Coordinate[] coordinates = coordinatesList.toArray(new org.locationtech.jts.geom.Coordinate[0]);
                geometry = geometryFactory.createPolygon(coordinates);
            }
            else if ("polyline".equals(shapeElement.getType())) {
                Coordinate[] coordinates = shapeElement.getCoordinates().get(0).stream()
                        .map(coord -> new org.locationtech.jts.geom.Coordinate(coord.getLng(), coord.getLat()))
                        .toArray(org.locationtech.jts.geom.Coordinate[]::new);
                geometry = geometryFactory.createLineString(coordinates);
            } else if ("marker".equals(shapeElement.getType()) || "circlemarker".equals(shapeElement.getType())) {
                ShapeDataDTO.Coordinate dtoCoord = shapeElement.getCenter();
                org.locationtech.jts.geom.Coordinate coordinate = new org.locationtech.jts.geom.Coordinate(dtoCoord.getLng(), dtoCoord.getLat());
                geometry = geometryFactory.createPoint(coordinate);
            } else {
                throw new IllegalArgumentException("Unknown shape type: " + shapeElement.getType());
            }

            geometries.add(geometry);
        }

        GeometryCollection geometryCollection = new GeometryCollection(geometries.toArray(new Geometry[0]), geometryFactory);
        shapeGeoserver.setGeometry(geometryCollection);

        shapeGeoserverRepository.save(shapeGeoserver);

        return shapeGeoserver;
    }









    //POLYLINE

    public ShapeGeoserver saveShapePolyline(ShapeDataPolylineDTO shapeDataDTO, Long userId, String shapeName) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);

        ShapeGeoserver shapeGeoserver = new ShapeGeoserver();
        shapeGeoserver.setUser(user);
        shapeGeoserver.setShapename(shapeName);

        ArrayList<Geometry> geometries = new ArrayList<>();

        for (ShapeDataPolylineDTO.CoordinateArray shapeElement : shapeDataDTO.getShapeData()) {
            if ("polyline".equals(shapeElement.getType())) {
                Coordinate[] coordinates = shapeElement.getCoordinates().stream()
                        .map(coord -> new org.locationtech.jts.geom.Coordinate(coord.getLng(), coord.getLat()))
                        .toArray(org.locationtech.jts.geom.Coordinate[]::new);
                Geometry geometry = geometryFactory.createLineString(coordinates);
                geometries.add(geometry);
            } else {
                throw new IllegalArgumentException("Unknown shape type: " + shapeElement.getType());
            }
        }

        GeometryCollection geometryCollection = new GeometryCollection(geometries.toArray(new Geometry[0]), geometryFactory);
        shapeGeoserver.setGeometry(geometryCollection);

        shapeGeoserverRepository.save(shapeGeoserver);

        return shapeGeoserver;
    }


    //Marker

    public ShapeGeoserver saveShapeMarker(RootDTO rootDTO, Long userId, String shapeName) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);

        ShapeGeoserver shapeGeoserver = new ShapeGeoserver();
        shapeGeoserver.setUser(user);
        shapeGeoserver.setShapename(shapeName);

        ArrayList<Geometry> geometries = new ArrayList<>();

        for (RootDTO.ShapeDataMarkerDTO shapeDataDTO : rootDTO.getShapeData()) {
            Geometry geometry;

            if ("marker".equals(shapeDataDTO.getType())) {
                RootDTO.ShapeDataMarkerDTO.Coordinate dtoCoord = shapeDataDTO.getCoordinates();
                org.locationtech.jts.geom.Coordinate coordinate = new org.locationtech.jts.geom.Coordinate(dtoCoord.getLng(), dtoCoord.getLat());
                geometry = geometryFactory.createPoint(coordinate);
            } else {
                throw new IllegalArgumentException("Unknown shape type: " + shapeDataDTO.getType());
            }

            geometries.add(geometry);
        }

        GeometryCollection geometryCollection = new GeometryCollection(geometries.toArray(new Geometry[0]), geometryFactory);
        shapeGeoserver.setGeometry(geometryCollection);

        shapeGeoserverRepository.save(shapeGeoserver);

        return shapeGeoserver;
    }










}

