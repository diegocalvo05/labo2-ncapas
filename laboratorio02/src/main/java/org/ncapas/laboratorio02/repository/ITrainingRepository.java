package org.ncapas.laboratorio02.repository;

import jakarta.transaction.Transactional;
import org.ncapas.laboratorio02.domain.entity.Training;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

@Transactional
public interface ITrainingRepository extends IGenericRepository<Training, UUID> {

    List<Training> findByTopic(String topic);

    @Query("SELECT t FROM Training t WHERE LOWER(t.topic) LIKE LOWER(CONCAT('%', :word, '%'))")
    List<Training> searchByKeywordInTopic(@Param("word") String word);

    @Query(value = "SELECT * FROM training WHERE duration > :minHours", nativeQuery = true)
    List<Training> findByMinDuration(@Param("minHours") Integer minHours);
}
