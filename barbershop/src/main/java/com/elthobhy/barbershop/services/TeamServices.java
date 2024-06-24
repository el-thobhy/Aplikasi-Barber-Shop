package com.elthobhy.barbershop.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elthobhy.barbershop.datamodels.MasterTeam;
import com.elthobhy.barbershop.repositories.TeamRepository;

@Service
public class TeamServices implements GenericCrud<MasterTeam, Integer> {
    @Autowired
    private TeamRepository repo;

    @Override
    public MasterTeam create(MasterTeam data) {
        return repo.save(data);
    }

    @Override
    public List<MasterTeam> read() {
        return repo.findByDeleted(false).get();
    }

    @Override
    public MasterTeam update(MasterTeam entity) {
        MasterTeam checkId = repo.findById(entity.getId()).get();
        if (checkId.getId() > 0) {
            entity.setUpdateBy(1);
            entity.setUpdateDate(LocalDateTime.now());
            entity.setCreateBy(checkId.getCreateBy());
            entity.setCreateDate(checkId.getCreateDate());
            entity.setDeleted(checkId.isDeleted());
            return repo.save(entity);
        } else {
            return new MasterTeam();
        }
    }

    @Override
    public MasterTeam getById(Integer id) {
        return repo.findById(id).get();
    }

    @Override
    public boolean softDelete(Integer id) {
        MasterTeam checkId = repo.findById(id).get();
        if (checkId.getId() > 0) {
            repo.softDelete(id, 1);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean hardDelete(Integer id) {
        MasterTeam checkId = repo.findById(id).get();
        if (checkId.getId() > 0) {
            repo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
