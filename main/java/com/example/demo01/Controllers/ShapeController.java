package com.example.demo01.Controllers;

import com.example.demo01.DTOs.*;
import com.example.demo01.Entities.Shape;
import com.example.demo01.Entities.ShapeGeoserver;
import com.example.demo01.Entities.User;
import com.example.demo01.Services.CustomUserDetailsService;
import com.example.demo01.Services.ShapeGeoserverService;
import com.example.demo01.Services.ShapeService;
import com.example.demo01.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShapeController {
    private ShapeService shapeService;
    private ShapeGeoserverService shapeGeoserverService;
    private CustomUserDetailsService customUserDetailsService;
    private UserService userService;
    @Autowired
    public ShapeController(ShapeGeoserverService shapeGeoserverService,ShapeService shapeService, CustomUserDetailsService customUserDetailsService, UserService userService) {
        this.shapeService = shapeService;
        this.customUserDetailsService = customUserDetailsService;
        this.userService = userService;
        this.shapeGeoserverService=shapeGeoserverService;
    }


   /* @PostMapping("/save")
    public ResponseEntity<Shape> saveShapes(@RequestParam Long userId, @RequestParam String shapeName, @RequestBody String shapeData){
        Shape shape = new Shape();
        shape.setshapeData(shapeData);
        shape.setshapeNames(shapeName);

        Shape savedShape = shape.saveShape(shape, userId);
        return new ResponseEntity<>(savedShape, HttpStatus.OK);
    }*/




  /*  @PostMapping("/save")
    public ResponseEntity<ShapeGeoserver> saveShapes(@RequestParam Long userId,@RequestParam String shapeName,@RequestBody ShapeDataDTO shapeDataDTO){
        ShapeGeoserver savedShape = shapeGeoserverService.saveShape(shapeDataDTO, userId);
        return new ResponseEntity<>(savedShape, HttpStatus.OK);
    }*/

    @PostMapping("/save")
    public ResponseEntity<ShapeGeoserver> saveShapes(@RequestParam Long userId,@RequestParam String shapeName,@RequestBody ShapeDataDTO shapeDataDTO){
        ShapeGeoserver savedShape = shapeGeoserverService.saveShape(shapeDataDTO, userId, shapeName);
        return new ResponseEntity<>(savedShape, HttpStatus.OK);
    }



    @PostMapping("/savePolyine")
    public ResponseEntity<ShapeGeoserver> saveShapePolyline(@RequestParam Long userId,@RequestParam String shapeName,@RequestBody ShapeDataPolylineDTO shapeDataPolylineDTO){
        ShapeGeoserver savedShape = shapeGeoserverService.saveShapePolyline(shapeDataPolylineDTO, userId, shapeName);
        return new ResponseEntity<>(savedShape, HttpStatus.OK);
    }

    @PostMapping("/saveMarker")
    public ResponseEntity<ShapeGeoserver> saveShapePolyline(@RequestParam Long userId,@RequestParam String shapeName,@RequestBody RootDTO rootDTO){
        ShapeGeoserver savedShape = shapeGeoserverService.saveShapeMarker(rootDTO, userId, shapeName);

        return new ResponseEntity<>(savedShape, HttpStatus.OK);


    }



    @GetMapping("/userShapes")
    public ResponseEntity<List<ShapeDto>> getUserShapes() {
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(
                SecurityContextHolder.getContext().getAuthentication().getName());
        User user = customUserDetailsService.findByUsername(userDetails.getUsername());
        List<ShapeGeoserver> shapes = shapeGeoserverService.ShapeDataBring(user.getId());
        List<ShapeDto> shapeDtos = new ArrayList<>();
        for (ShapeGeoserver shape: shapes) {
            ShapeDto shapeDto = new ShapeDto();
            shapeDto.setId(shape.getId());
           // shapeDto.setShapeInformation(shape.getGeometry().toString());
            shapeDto.setShapeNames(shape.getShapename());
            shapeDtos.add(shapeDto);
        }
        return new ResponseEntity<>(shapeDtos, HttpStatus.OK);
    }

}

