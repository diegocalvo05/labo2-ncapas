package org.ncapas.laboratorio02.repository;

import org.ncapas.laboratorio02.domain.entity.Assessment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface IAssessmentRepository extends IGenericRepository<Assessment, UUID> {

    List<Assessment> findByCommentContainingIgnoreCase(String comment);

    @Query("SELECT a FROM Assessment a WHERE a.employee.firstName = :firstName")
    List<Assessment> findByEmployeeName(@Param("firstName") String firstName);

    @Query(value = "SELECT * FROM assessment WHERE quantification >= :minScore", nativeQuery = true)
    List<Assessment> findByMinQuantification(@Param("minScore") Integer minScore);
}
