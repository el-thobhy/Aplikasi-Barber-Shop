package com.elthobhy.barbershop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elthobhy.barbershop.datamodels.MasterCustomer;

@Repository
public interface CustomerRepository extends JpaRepository<MasterCustomer, Integer> {

}
