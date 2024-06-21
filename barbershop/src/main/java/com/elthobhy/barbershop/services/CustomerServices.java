package com.elthobhy.barbershop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elthobhy.barbershop.datamodels.MasterCustomer;
import com.elthobhy.barbershop.repositories.CustomerRepository;

@Service
public class CustomerServices {
    @Autowired
    private CustomerRepository repo;

    public MasterCustomer create(MasterCustomer data) {
        return repo.save(data);
    }

    public List<MasterCustomer> read() {
        return repo.findAll();
    }
}
