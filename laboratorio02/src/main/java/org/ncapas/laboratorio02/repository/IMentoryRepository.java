package org.ncapas.laboratorio02.repository;

import org.ncapas.laboratorio02.domain.entity.Mentory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface IMentoryRepository extends IGenericRepository<Mentory, Integer> {

    List<Mentory> findByMentor_Id(UUID mentorId);

    @Query("SELECT m FROM Mentory m WHERE m.mentored.id = :mentoredId")
    List<Mentory> findByMentoredId(@Param("mentoredId") UUID mentoredId);

    @Query(value = "SELECT * FROM mentory WHERE time > :minTime", nativeQuery = true)
    List<Mentory> findByMinDuration(@Param("minTime") Integer minTime);
}
