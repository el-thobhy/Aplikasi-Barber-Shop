package com.elthobhy.barbershop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elthobhy.barbershop.datamodels.MasterServices;

@Repository
public interface ServiceRepository extends JpaRepository<MasterServices, Integer> {

}
