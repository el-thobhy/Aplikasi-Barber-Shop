package com.elthobhy.barbershop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elthobhy.barbershop.datamodels.TransactionOrder;
import com.elthobhy.barbershop.repositories.OrderRepository;

@Service
public class OrderServices {
    @Autowired
    private OrderRepository repo;

    public TransactionOrder create(TransactionOrder order) {
        return repo.save(order);
    }

    public List<TransactionOrder> read() {
        return repo.findAll();
    }
}
