package com.elthobhy.barbershop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elthobhy.barbershop.datamodels.MasterTeam;
import com.elthobhy.barbershop.repositories.TeamRepository;

@Service
public class TeamServices {
    @Autowired
    private TeamRepository repo;

    public MasterTeam create(MasterTeam data) {
        return repo.save(data);
    }

    public List<MasterTeam> read() {
        return repo.findAll();
    }
}
