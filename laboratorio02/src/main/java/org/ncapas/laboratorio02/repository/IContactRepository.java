package org.ncapas.laboratorio02.repository;

import jakarta.transaction.Transactional;
import org.ncapas.laboratorio02.domain.entity.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Transactional
public interface IContactRepository extends IGenericRepository<Contact, Integer> {
    List<Contact> findByEmailEndingWith(String domain);

    @Query("SELECT c FROM Contact c WHERE c.lastName = :lastName")
    List<Contact> findByLastNameJPQL(@Param("lastName") String lastName);

    @Query(value = "SELECT * FROM contact WHERE first_name = :firstName", nativeQuery = true)
    List<Contact> findByFirstNameNative(@Param("firstName") String firstName);
}
