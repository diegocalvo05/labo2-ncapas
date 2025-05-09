package org.ncapas.laboratorio02.repository;

import org.ncapas.laboratorio02.domain.entity.Department;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IDepartmentRepository extends IGenericRepository<Department, Integer> {

    Department findByName(String name);

    @Query("SELECT d FROM Department d WHERE LOWER(d.name) LIKE LOWER(CONCAT('%', :word, '%'))")
    List<Department> findByNameContainingIgnoreCase(@Param("word") String word);

    @Query(value = "SELECT * FROM department WHERE name ILIKE :prefix || '%'", nativeQuery = true)
    List<Department> findByNameStartingWithNative(@Param("prefix") String prefix);
}
