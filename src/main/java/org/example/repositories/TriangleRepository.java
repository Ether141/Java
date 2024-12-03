package org.example.repositories;

import org.example.shapes.Triangle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TriangleRepository extends JpaRepository<Triangle, Long> {
}
