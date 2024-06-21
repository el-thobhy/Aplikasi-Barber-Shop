package com.elthobhy.barbershop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elthobhy.barbershop.datamodels.TransactionOrderServices;

@Repository
public interface OrderServicesRepository extends JpaRepository<TransactionOrderServices, Integer> {

}
