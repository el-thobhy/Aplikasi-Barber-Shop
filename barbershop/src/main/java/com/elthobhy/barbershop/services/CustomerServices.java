package com.elthobhy.barbershop.services;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elthobhy.barbershop.datamodels.MasterCustomer;
import com.elthobhy.barbershop.repositories.CustomerRepository;

@Service
public class CustomerServices implements GenericCrud<MasterCustomer, Integer> {
    @Autowired
    private CustomerRepository repo;

    @Override
    public MasterCustomer create(MasterCustomer data) {
        return repo.save(data);
    }

    @Override
    public List<MasterCustomer> read() {
        return repo.findByDeleted(false).get();
    }

    @Override
    public MasterCustomer update(MasterCustomer entity) {
        MasterCustomer checkId = repo.findById(entity.getId()).get();
        if (checkId.getId() > 0) {
            entity.setUpdateBy(1);
            entity.setUpdateDate(LocalDateTime.now());
            entity.setCreateBy(checkId.getCreateBy());
            entity.setCreateDate(checkId.getCreateDate());
            entity.setDeleted(checkId.isDeleted());
            return repo.save(entity);
        } else {
            return new MasterCustomer();
        }
    }

    @Override
    public MasterCustomer getById(Integer id) {
        return repo.findById(id).get();
    }

    @Override
    public boolean softDelete(Integer id) {
        MasterCustomer checkId = repo.findById(id).get();
        if (checkId.getId() > 0) {
            repo.softDelete(id, 1);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean hardDelete(Integer id) {
        MasterCustomer checkId = repo.findById(id).get();
        if (checkId.getId() > 0) {
            repo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
