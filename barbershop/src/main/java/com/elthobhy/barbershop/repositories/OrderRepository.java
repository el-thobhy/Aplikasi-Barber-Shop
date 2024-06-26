package com.elthobhy.barbershop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elthobhy.barbershop.datamodels.TransactionOrder;

@Repository
public interface OrderRepository extends JpaRepository<TransactionOrder, Integer> {

}
