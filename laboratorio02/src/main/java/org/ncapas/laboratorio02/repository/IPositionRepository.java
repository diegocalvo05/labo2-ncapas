package org.ncapas.laboratorio02.repository;

import jakarta.transaction.Transactional;
import org.ncapas.laboratorio02.domain.entity.Position;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Transactional
public interface IPositionRepository extends IGenericRepository<Position, Integer> {
    List<Position> findByNameContainingIgnoreCase(String name);

    @Query("SELECT p FROM Position p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Position> searchByName(@Param("name") String name);

    @Query(value = "SELECT * FROM position WHERE LOWER(name) LIKE LOWER(CONCAT('%', :name, '%'))", nativeQuery = true)
    List<Position> nativeSearchByName(@Param("name") String name);
}
