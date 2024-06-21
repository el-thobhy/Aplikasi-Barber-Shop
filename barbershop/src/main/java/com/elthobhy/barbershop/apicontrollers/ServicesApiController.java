package com.elthobhy.barbershop.apicontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}
