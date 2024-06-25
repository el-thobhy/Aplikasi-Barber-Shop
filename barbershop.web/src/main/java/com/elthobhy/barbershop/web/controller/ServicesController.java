package com.elthobhy.barbershop.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.elthobhy.barbershop.web.viewmodel.ServicesViewModel;

@Controller
@RequestMapping("/services")
public class ServicesController {
    private final String apiUrl = "http://localhost:7000/api/services";
    private RestTemplate restTemp = new RestTemplate();

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("/services/index");
        try {
            ResponseEntity<ServicesViewModel[]> apiResponse = restTemp.getForEntity(apiUrl, ServicesViewModel[].class);
            if (apiResponse.getStatusCode() == HttpStatus.OK) {
                ServicesViewModel[] data = apiResponse.getBody();
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
        ModelAndView view = new ModelAndView("/services/add");
        ServicesViewModel cat = new ServicesViewModel();
        view.addObject("services", cat);
        return view;
    }

    @PostMapping("/save")
    ResponseEntity<?> Save(@ModelAttribute ServicesViewModel data) {
        try {
            ResponseEntity<ServicesViewModel> apiResponse = restTemp.postForEntity(apiUrl, data,
                    ServicesViewModel.class);
            if (apiResponse.getStatusCode() == HttpStatus.CREATED) {
                System.out.println("New Services added");
                return new ResponseEntity<ServicesViewModel>(apiResponse.getBody(), apiResponse.getStatusCode());
            } else {
                throw new Exception("New Services cannot be added");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/edit/{id}")
    ModelAndView edit(@PathVariable Long id) throws Exception {
        ModelAndView view = new ModelAndView("/services/edit");
        try {
            ResponseEntity<ServicesViewModel> apiResponse = restTemp.getForEntity(apiUrl + "/GetById/" + id,
                    ServicesViewModel.class);
            if (apiResponse.getStatusCode() == HttpStatus.OK) {
                ServicesViewModel cat = apiResponse.getBody();
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
    ResponseEntity<?> update(ServicesViewModel data) {
        ResponseEntity<?> apiResponse = null;
        try {
            restTemp.put(apiUrl, data);
            apiResponse = restTemp.getForEntity(apiUrl + "/GetById/" + data.getId(), ServicesViewModel.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            apiResponse = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return apiResponse;
    }

    @GetMapping("/delete/{id}")
    ModelAndView GetdataDelete(@PathVariable Long id) throws Exception {
        ModelAndView view = new ModelAndView("/services/delete");
        try {
            ResponseEntity<ServicesViewModel> apiResponse = restTemp.getForEntity(apiUrl + "/GetById/" + id,
                    ServicesViewModel.class);
            if (apiResponse.getStatusCode() == HttpStatus.OK) {
                ServicesViewModel cat = apiResponse.getBody();
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
    ResponseEntity<?> Delete(ServicesViewModel data) {
        ResponseEntity<?> apiResponse = null;
        try {
            apiResponse = restTemp.getForEntity(apiUrl + "/GetById/" + data.getId(), ServicesViewModel.class);
            if (apiResponse.getStatusCode() == HttpStatus.OK) {
                restTemp.delete(apiUrl + "/softDelete/" + data.getId());
                apiResponse = new ResponseEntity<String>("Service ID " + data.getId() + " Deleted", HttpStatus.OK);
            } else
                throw new Exception("Services Id " + data.getId() + " cannot be deleted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            apiResponse = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return apiResponse;
    }

}
