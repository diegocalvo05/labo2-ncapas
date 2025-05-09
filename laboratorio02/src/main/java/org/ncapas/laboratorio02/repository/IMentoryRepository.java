package org.ncapas.laboratorio02.repository;

import jakarta.transaction.Transactional;
import org.ncapas.laboratorio02.domain.entity.Mentory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

@Transactional
public interface IMentoryRepository extends IGenericRepository<Mentory, Integer> {

    List<Mentory> findByMentor_IdEmployee(UUID idMentor);

    @Query("SELECT m FROM Mentory m WHERE m.mentored.idEmployee = :mentoredId")
    List<Mentory> findByMentoredId(@Param("mentoredId") UUID mentoredId);

    @Query(value = "SELECT * FROM mentory WHERE time > :minTime", nativeQuery = true)
    List<Mentory> findByMinDuration(@Param("minTime") Integer minTime);
}
