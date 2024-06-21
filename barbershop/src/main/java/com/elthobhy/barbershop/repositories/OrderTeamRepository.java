package com.elthobhy.barbershop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elthobhy.barbershop.datamodels.TransactionOrderTeam;

@Repository
public interface OrderTeamRepository extends JpaRepository<TransactionOrderTeam, Integer> {

}
