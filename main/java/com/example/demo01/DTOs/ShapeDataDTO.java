package com.example.demo01.DTOs;
import org.locationtech.jts.geom.Coordinate;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
/*public class ShapeDataDTO {
    private List<Shape2> shapeData;

    @Getter
    @Setter
    public static class Shape2 {
        private String type;
        private List<Coordinate> coordinates;
        private Coordinate center; // Added for circlemarker type
        private String shapeName;
        // ...


        public static class Coordinate {
            private double lat;
            private double lng;
            // getters and setters...
            public double getLat() {
                return lat;
            }

            public double getLng() {
                return lng;
            }
        }
    }
}*/
/*public class ShapeDataDTO {
    private String type;
    private String shapeName;
    private List<Coordinate> coordinates;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShapeName() {
        return shapeName;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinate> coordinates) {
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
}*/



public class ShapeDataDTO {
    private List<ShapeElement> shapeData;

    public List<ShapeElement> getShapeData() {
        return shapeData;
    }

    public void setShapeData(List<ShapeElement> shapeData) {
        this.shapeData = shapeData;
    }

    public static class ShapeElement {
        private String type;
        private List<List<Coordinate>> coordinates;

        private Coordinate center;
        private Integer radius;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

       public List<List<Coordinate>> getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(List<List<Coordinate>> coordinates) {
            this.coordinates = coordinates;
        }





        public Coordinate getCenter() {
            return center;
        }

        public void setCenter(Coordinate center) {
            this.center = center;
        }

        public Integer getRadius() {
            return radius;
        }

        public void setRadius(Integer radius) {
            this.radius = radius;
        }
    }

    public static class Coordinate {
        private Double lat;
        private Double lng;

        public Double getLat() {
            return lat;
        }

        public void setLat(Double lat) {
            this.lat = lat;
        }

        public Double getLng() {
            return lng;
        }

        public void setLng(Double lng) {
            this.lng = lng;
        }
    }
}





