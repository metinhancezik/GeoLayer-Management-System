package com.example.demo01.DTOs;

import java.util.List;

public class ShapeDataPolylineDTO {
    private List<CoordinateArray> shapeData;

    public List<CoordinateArray> getShapeData() {
        return shapeData;
    }

    public void setShapeData(List<CoordinateArray> shapeData) {
        this.shapeData = shapeData;
    }

    public static class CoordinateArray {
        private String type;
        private List<Coordinate> coordinates;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<Coordinate> getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(List<Coordinate> coordinates) {
            this.coordinates = coordinates;
        }
    }

    public static class Coordinate {
        private double lat;
        private double lng;

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }
    }
}
