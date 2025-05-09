package org.ncapas.laboratorio02.repository;

import jakarta.transaction.Transactional;
import org.ncapas.laboratorio02.domain.entity.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

@Transactional
public interface IProjectRepository extends IGenericRepository<Project, UUID> {

    Project findByCode(String code);

    @Query("SELECT p FROM Project p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :word, '%'))")
    List<Project> searchByNameFragment(@Param("word") String word);


    @Query(value = "SELECT * FROM project WHERE status ILIKE 'Activo%'", nativeQuery = true)
    List<Project> findActiveProjectsNative();
}
