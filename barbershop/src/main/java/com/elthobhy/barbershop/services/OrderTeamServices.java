package com.elthobhy.barbershop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elthobhy.barbershop.datamodels.TransactionOrderTeam;
import com.elthobhy.barbershop.repositories.OrderTeamRepository;

@Service
public class OrderTeamServices {
    @Autowired
    private OrderTeamRepository repo;

    public TransactionOrderTeam create(TransactionOrderTeam data) {
        return repo.save(data);
    }

    public List<TransactionOrderTeam> read() {
        return repo.findAll();
    }
}
