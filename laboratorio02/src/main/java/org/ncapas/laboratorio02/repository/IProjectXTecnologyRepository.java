package org.ncapas.laboratorio02.repository;

import jakarta.transaction.Transactional;
import org.ncapas.laboratorio02.domain.entity.ProjectXTecnology;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Transactional
public interface IProjectXTecnologyRepository extends IGenericRepository<ProjectXTecnology, Integer> {

    List<ProjectXTecnology> findByTecnology_IdTecnology(Integer tecnologyId);


    @Query("SELECT pt FROM ProjectXTecnology pt WHERE LOWER(pt.project.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<ProjectXTecnology> findByProjectName(@Param("name") String name);


    @Query(value = "SELECT pt.* FROM project_x_tecnology pt JOIN tecnology t ON pt.id_tecnology = t.id_tecnology WHERE t.name = :techName", nativeQuery = true)
    List<ProjectXTecnology> findByTechnologyNameNative(@Param("techName") String techName);
}
