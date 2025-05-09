package org.ncapas.laboratorio02.repository;

import jakarta.transaction.Transactional;
import org.ncapas.laboratorio02.domain.entity.AreaCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Transactional
public interface IAreaCategoryRepository extends IGenericRepository<AreaCategory, Integer> {

    AreaCategory findByName(String name);

    @Query("SELECT ac FROM AreaCategory ac WHERE LOWER(ac.name) LIKE LOWER(CONCAT('%', :fragment, '%'))")
    List<AreaCategory> findByNameFragment(@Param("fragment") String fragment);

    @Query(value = "SELECT * FROM area_category WHERE name ILIKE :prefix || '%'", nativeQuery = true)
    List<AreaCategory> findByStartingWith(@Param("prefix") String prefix);
}
