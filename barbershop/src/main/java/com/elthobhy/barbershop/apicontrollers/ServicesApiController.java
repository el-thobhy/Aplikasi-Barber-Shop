package com.elthobhy.barbershop.apicontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elthobhy.barbershop.datamodels.MasterServices;
import com.elthobhy.barbershop.services.ServiceServices;

@RestController
@CrossOrigin("*")
@RequestMapping("api/services")
public class ServicesApiController {
    @Autowired
    private ServiceServices serviceSvc;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody MasterServices data) {
        try {
            MasterServices result = serviceSvc.create(data);
            if (result.getId() > 0) {
                return new ResponseEntity<MasterServices>(result, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<String>("Service Already Exist", HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<?> read() {
        try {
            List<MasterServices> data = serviceSvc.read();
            if (!data.isEmpty()) {
                return new ResponseEntity<List<MasterServices>>(data, HttpStatus.OK);
            } else
                return new ResponseEntity<String>("Data Is null", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody MasterServices entity) {
        try {
            MasterServices result = serviceSvc.update(entity);
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
            boolean isExist = serviceSvc.softDelete(id);
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
            boolean isExist = serviceSvc.hardDelete(id);
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
            MasterServices isExist = serviceSvc.getById(id);
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
