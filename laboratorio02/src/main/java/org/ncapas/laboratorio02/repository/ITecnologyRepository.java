package org.ncapas.laboratorio02.repository;

import jakarta.transaction.Transactional;
import org.ncapas.laboratorio02.domain.entity.Tecnology;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Transactional
public interface ITecnologyRepository extends IGenericRepository<Tecnology, Integer> {

    Tecnology findByName(String name);

    @Query("SELECT t FROM Tecnology t WHERE LOWER(t.name) LIKE LOWER(CONCAT('%', :word, '%'))")
    List<Tecnology> searchByKeyword(@Param("word") String word);


    @Query(value = "SELECT * FROM tecnology WHERE version = :version", nativeQuery = true)
    List<Tecnology> findByVersionNative(@Param("version") String version);
}
