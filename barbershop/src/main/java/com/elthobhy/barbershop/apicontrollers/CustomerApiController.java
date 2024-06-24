package com.elthobhy.barbershop.apicontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elthobhy.barbershop.datamodels.MasterCustomer;
import com.elthobhy.barbershop.services.CustomerServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin("*")
@RequestMapping("api/customer")
public class CustomerApiController {
    @Autowired
    private CustomerServices customerSvc;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody MasterCustomer data) {
        try {
            MasterCustomer result = customerSvc.create(data);
            if (result.getId() > 0) {
                return new ResponseEntity<MasterCustomer>(result, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<String>("Error create data", HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<?> read() {
        try {
            List<MasterCustomer> result = customerSvc.read();
            if (!result.isEmpty()) {
                return new ResponseEntity<>(result, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Data is null", HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody MasterCustomer entity) {
        try {
            MasterCustomer result = customerSvc.update(entity);
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
            boolean isExist = customerSvc.softDelete(id);
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
            boolean isExist = customerSvc.hardDelete(id);
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
            MasterCustomer isExist = customerSvc.getById(id);
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
