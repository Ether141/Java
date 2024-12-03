package org.example.services;

import org.example.repositories.RectangleRepository;
import org.example.repositories.TriangleRepository;
import org.example.shapes.Rectangle;
import org.example.shapes.Triangle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShapeService {
    private final RectangleRepository rectangleRepository;
    private final TriangleRepository triangleRepository;

    public ShapeService(RectangleRepository rectangleRepository, TriangleRepository triangleRepository) {
        this.rectangleRepository = rectangleRepository;
        this.triangleRepository = triangleRepository;
    }

    public List<Rectangle> getAllRectangles() {
        return rectangleRepository.findAll();
    }

    public List<Triangle> getAllTriangles() {
        return triangleRepository.findAll();
    }

    public Long addRectangle(Rectangle rectangle) {
        return rectangleRepository.save(rectangle).getId();
    }

    public Long addTriangle(Triangle triangle) {
        return triangleRepository.save(triangle).getId();
    }

    public boolean doesRectangleExist(Long id) {
        return rectangleRepository.existsById(id);
    }

    public boolean doesTriangleExist(Long id) {
        return triangleRepository.existsById(id);
    }

    public void deleteRectangle(Long id) {
        rectangleRepository.deleteById(id);
    }

    public void deleteTriangle(Long id) {
        triangleRepository.deleteById(id);
    }
}
