package org.ncapas.laboratorio02.repository;

import jakarta.transaction.Transactional;
import org.ncapas.laboratorio02.domain.entity.EmployeeXTraining;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

@Transactional
public interface IEmployeeXTrainingRepository extends IGenericRepository<EmployeeXTraining, Integer> {

    List<EmployeeXTraining> findByIdEmployee_IdEmployee(UUID idEmployee);

    @Query("SELECT et FROM EmployeeXTraining et WHERE LOWER(et.idTraining.topic) LIKE LOWER(CONCAT('%', :topic, '%'))")
    List<EmployeeXTraining> findByTrainingTopic(@Param("topic") String topic);


}
