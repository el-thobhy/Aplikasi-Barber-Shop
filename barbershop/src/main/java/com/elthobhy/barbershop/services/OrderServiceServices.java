package com.elthobhy.barbershop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elthobhy.barbershop.datamodels.TransactionOrderServices;
import com.elthobhy.barbershop.repositories.OrderServicesRepository;

@Service
public class OrderServiceServices {
    @Autowired
    private OrderServicesRepository repo;

    public TransactionOrderServices create(TransactionOrderServices data) {
        return repo.save(data);
    }

    public List<TransactionOrderServices> read() {
        return repo.findAll();
    }
}
