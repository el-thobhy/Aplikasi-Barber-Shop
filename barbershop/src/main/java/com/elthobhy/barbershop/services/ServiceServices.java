package com.elthobhy.barbershop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elthobhy.barbershop.datamodels.MasterServices;
import com.elthobhy.barbershop.repositories.ServiceRepository;

@Service
public class ServiceServices {
    @Autowired
    private ServiceRepository repo;

    public MasterServices create(MasterServices data) {
        return repo.save(data);
    }

    public List<MasterServices> read() {
        return repo.findAll();
    }
}
