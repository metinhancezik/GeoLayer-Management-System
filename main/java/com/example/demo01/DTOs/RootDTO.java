package com.example.demo01.DTOs;

import java.util.List;

public class RootDTO {
    private List<ShapeDataMarkerDTO> shapeData;

    public List<ShapeDataMarkerDTO> getShapeData() {
        return shapeData;
    }

    public void setShapeData(List<ShapeDataMarkerDTO> shapeData) {
        this.shapeData = shapeData;
    }

    public static class ShapeDataMarkerDTO {
        private String type;
        private Coordinate coordinates;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Coordinate getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(Coordinate coordinates) {
            this.coordinates = coordinates;
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
}

