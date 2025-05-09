package org.ncapas.laboratorio02.repository;

import org.ncapas.laboratorio02.domain.entity.EmployeeXProject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface IEmployeeXProjectRepository extends IGenericRepository<EmployeeXProject, Integer> {

    List<EmployeeXProject> findByEmployee_Id(UUID employeeId);


    @Query("SELECT ep FROM EmployeeXProject ep WHERE LOWER(ep.project.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<EmployeeXProject> findByProjectNameFragment(@Param("name") String name);

    @Query(value = "SELECT * FROM employee_x_project WHERE entry_date = :entryDate", nativeQuery = true)
    List<EmployeeXProject> findByEntryDate(@Param("entryDate") String entryDate); // o usar java.sql.Date
}
