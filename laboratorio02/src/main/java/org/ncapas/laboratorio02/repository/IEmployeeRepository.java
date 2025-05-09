package org.ncapas.laboratorio02.repository;

import jakarta.transaction.Transactional;
import org.ncapas.laboratorio02.domain.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

@Transactional
public interface IEmployeeRepository extends IGenericRepository<Employee, UUID> {

    List<Employee> findByName(String name);

    @Query("SELECT e FROM Employee e WHERE e.department.name = :deptName")
    List<Employee> findByDepartmentName(@Param("deptName") String deptName);

    @Query(value = "SELECT * FROM employee WHERE surname = :surname", nativeQuery = true)
    List<Employee> findByLastNameNative(@Param("surname") String surname);
}
