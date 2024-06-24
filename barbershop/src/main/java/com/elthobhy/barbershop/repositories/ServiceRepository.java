package com.elthobhy.barbershop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.elthobhy.barbershop.datamodels.MasterServices;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface ServiceRepository extends JpaRepository<MasterServices, Integer> {
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE master_service SET deleted=true, update_by=:updateBy, update_date=now() WHERE id=:id", nativeQuery = true)
    public void softDelete(@Param("id") Integer id, @Param("updateBy") Integer updateBy);

    Optional<List<MasterServices>> findByDeleted(boolean deleted);
}
