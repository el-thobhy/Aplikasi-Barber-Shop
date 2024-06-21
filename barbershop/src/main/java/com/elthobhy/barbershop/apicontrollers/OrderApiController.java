package com.elthobhy.barbershop.apicontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elthobhy.barbershop.datamodels.TransactionOrder;
import com.elthobhy.barbershop.services.OrderServices;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@CrossOrigin("*")
@RequestMapping("api/orders")
public class OrderApiController {
    @Autowired
    private OrderServices orderSvc;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody TransactionOrder data) {
        try {
            TransactionOrder result = orderSvc.create(data);
            if (result.getId() > 0) {
                return new ResponseEntity<TransactionOrder>(result, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<String>("Error create order", HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<?> read() {
        try {
            List<TransactionOrder> data = orderSvc.read();
            if (!data.isEmpty()) {
                return new ResponseEntity<List<TransactionOrder>>(data, HttpStatus.OK);
            } else
                return new ResponseEntity<String>("Data Is null", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
