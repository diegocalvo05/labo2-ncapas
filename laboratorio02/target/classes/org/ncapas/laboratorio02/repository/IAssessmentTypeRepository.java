package org.ncapas.laboratorio02.repository;

import org.ncapas.laboratorio02.domain.entity.AssessmentType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAssessmentTypeRepository extends IGenericRepository<AssessmentType, Integer> {

    AssessmentType findByName(String name);


    @Query("SELECT at FROM AssessmentType at WHERE LOWER(at.name) LIKE LOWER(CONCAT('%', :word, '%'))")
    List<AssessmentType> findByNameContaining(@Param("word") String word);

    @Query(value = "SELECT * FROM assessment_type WHERE name ILIKE :prefix || '%'", nativeQuery = true)
    List<AssessmentType> findByStartingWith(@Param("prefix") String prefix);
}
