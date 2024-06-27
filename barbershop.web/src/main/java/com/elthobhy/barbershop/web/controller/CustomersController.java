package com.elthobhy.barbershop.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.elthobhy.barbershop.web.viewmodel.CustomerViewModel;

@Controller
@RequestMapping("/customers")
public class CustomersController {
    private final String apiUrl = "http://localhost:7000/api/customer";
    private RestTemplate restTemp = new RestTemplate();

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("/customers/index");
        try {
            ResponseEntity<CustomerViewModel[]> apiResponse = restTemp.getForEntity(apiUrl, CustomerViewModel[].class);
            if (apiResponse.getStatusCode() == HttpStatus.OK) {
                CustomerViewModel[] data = apiResponse.getBody();
                view.addObject("data", data);
            } else {
                throw new Exception(apiResponse.getStatusCode().toString() + ":" + apiResponse.getBody());
            }
        } catch (Exception e) {
            view.addObject("errorMessage", e.getMessage());
        }
        return view;
    }

    @GetMapping("/add")
    ModelAndView Add() {
        ModelAndView view = new ModelAndView("/customers/add");
        CustomerViewModel cat = new CustomerViewModel();
        view.addObject("customer", cat);
        return view;
    }

    @PostMapping("/save")
    ResponseEntity<?> Save(@ModelAttribute CustomerViewModel data) {
        try {
            ResponseEntity<CustomerViewModel> apiResponse = restTemp.postForEntity(apiUrl, data,
                    CustomerViewModel.class);
            if (apiResponse.getStatusCode() == HttpStatus.CREATED) {
                System.out.println("New Customer added");
                return new ResponseEntity<CustomerViewModel>(apiResponse.getBody(), apiResponse.getStatusCode());
            } else {
                throw new Exception("New Customer cannot be added");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/edit/{id}")
    ModelAndView edit(@PathVariable Long id) throws Exception {
        ModelAndView view = new ModelAndView("/customers/edit");
        try {
            ResponseEntity<CustomerViewModel> apiResponse = restTemp.getForEntity(apiUrl + "/GetById/" + id,
                    CustomerViewModel.class);
            if (apiResponse.getStatusCode() == HttpStatus.OK) {
                CustomerViewModel cat = apiResponse.getBody();
                view.addObject("fill", cat);
            } else {
                throw new Exception(apiResponse.getStatusCode().toString() + ":" + apiResponse.getBody());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return view;
    }

    @PostMapping("/update")
    ResponseEntity<?> update(CustomerViewModel data) {
        ResponseEntity<?> apiResponse = null;
        try {
            restTemp.put(apiUrl, data);
            apiResponse = restTemp.getForEntity(apiUrl + "/GetById/" + data.getId(), CustomerViewModel.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            apiResponse = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return apiResponse;
    }

    @GetMapping("/delete/{id}")
    ModelAndView GetdataDelete(@PathVariable Long id) throws Exception {
        ModelAndView view = new ModelAndView("/customers/delete");
        try {
            ResponseEntity<CustomerViewModel> apiResponse = restTemp.getForEntity(apiUrl + "/GetById/" + id,
                    CustomerViewModel.class);
            if (apiResponse.getStatusCode() == HttpStatus.OK) {
                CustomerViewModel cat = apiResponse.getBody();
                view.addObject("fill", cat);
            } else {
                throw new Exception(apiResponse.getStatusCode().toString() + ":" + apiResponse.getBody());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return view;
    }

    @PostMapping("/deleteAction")
    ResponseEntity<?> Delete(CustomerViewModel data) {
        ResponseEntity<?> apiResponse = null;
        try {
            apiResponse = restTemp.getForEntity(apiUrl + "/GetById/" + data.getId(), CustomerViewModel.class);
            if (apiResponse.getStatusCode() == HttpStatus.OK) {
                restTemp.delete(apiUrl + "/softDelete/" + data.getId());
                apiResponse = new ResponseEntity<String>("Service ID " + data.getId() + " Deleted", HttpStatus.OK);
            } else
                throw new Exception("Customer Id " + data.getId() + " cannot be deleted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            apiResponse = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return apiResponse;
    }

}
