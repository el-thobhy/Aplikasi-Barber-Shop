package com.elthobhy.barbershop.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elthobhy.barbershop.datamodels.MasterServices;
import com.elthobhy.barbershop.repositories.ServiceRepository;

@Service
public class ServiceServices implements GenericCrud<MasterServices, Integer> {
    @Autowired
    private ServiceRepository repo;

    @Override
    public MasterServices create(MasterServices data) {
        data.setCreateBy(1);
        data.setCreateDate(LocalDateTime.now());
        return repo.save(data);
    }

    @Override
    public List<MasterServices> read() {
        return repo.findByDeleted(false).get();
    }

    @Override
    public MasterServices update(MasterServices entity) {
        MasterServices checkId = repo.findById(entity.getId()).get();
        if (checkId.getId() > 0) {
            entity.setUpdateBy(1);
            entity.setUpdateDate(LocalDateTime.now());
            entity.setCreateBy(checkId.getCreateBy());
            entity.setCreateDate(checkId.getCreateDate());
            entity.setDeleted(checkId.isDeleted());
            return repo.save(entity);
        } else {
            return new MasterServices();
        }
    }

    @Override
    public MasterServices getById(Integer id) {
        return repo.findById(id).get();
    }

    @Override
    public boolean softDelete(Integer id) {
        MasterServices checkId = repo.findById(id).get();
        if (checkId.getId() > 0) {
            repo.softDelete(id, 1);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean hardDelete(Integer id) {
        MasterServices checkId = repo.findById(id).get();
        if (checkId.getId() > 0) {
            repo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
