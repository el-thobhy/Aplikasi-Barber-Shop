package com.elthobhy.barbershop.apicontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elthobhy.barbershop.datamodels.MasterTeam;
import com.elthobhy.barbershop.services.TeamServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin("*")
@RequestMapping("api/teams")
public class TeamApiController {
    @Autowired
    private TeamServices teamSvc;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody MasterTeam data) {
        try {
            MasterTeam result = teamSvc.create(data);
            if (result.getId() > 0) {
                return new ResponseEntity<>(result, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("error create", HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<?> read() {
        try {
            List<MasterTeam> result = teamSvc.read();
            if (!result.isEmpty()) {
                return new ResponseEntity<>(result, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("error get data", HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody MasterTeam entity) {
        try {
            MasterTeam result = teamSvc.update(entity);
            if (result.getId() > 0) {
                return new ResponseEntity<>(result, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Null", HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("softDelete/{id}")
    public ResponseEntity<?> softDelete(@PathVariable Integer id) {
        try {
            boolean isExist = teamSvc.softDelete(id);
            if (isExist) {
                return new ResponseEntity<>(isExist, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("fail delete", HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("hardDelete/{id}")
    public ResponseEntity<?> hardDelete(@PathVariable Integer id) {
        try {
            boolean isExist = teamSvc.hardDelete(id);
            if (isExist) {
                return new ResponseEntity<>(isExist, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("fail delete", HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("GetById/{id}")
    public ResponseEntity<?> getByIdCustomer(@PathVariable Integer id) {
        try {
            MasterTeam isExist = teamSvc.getById(id);
            if (isExist.getId() > 0) {
                return new ResponseEntity<>(isExist, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("fail delete", HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
