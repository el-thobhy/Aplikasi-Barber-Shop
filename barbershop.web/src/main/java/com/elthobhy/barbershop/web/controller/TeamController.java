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

import com.elthobhy.barbershop.web.viewmodel.RoleTeam;
import com.elthobhy.barbershop.web.viewmodel.TeamStatus;
import com.elthobhy.barbershop.web.viewmodel.TeamViewModel;

@Controller
@RequestMapping("/teams")
public class TeamController {
    private final String apiUrl = "http://localhost:7000/api/teams";
    private RestTemplate restTemp = new RestTemplate();

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("/teams/index");
        try {
            ResponseEntity<TeamViewModel[]> apiResponse = restTemp.getForEntity(apiUrl, TeamViewModel[].class);
            if (apiResponse.getStatusCode() == HttpStatus.OK) {
                TeamViewModel[] data = apiResponse.getBody();
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
        ModelAndView view = new ModelAndView("/teams/add");
        TeamViewModel cat = new TeamViewModel();
        view.addObject("teams", cat);
        view.addObject("roles", RoleTeam.values());
        view.addObject("status", TeamStatus.values());
        return view;
    }

    @PostMapping("/save")
    ResponseEntity<?> Save(@ModelAttribute TeamViewModel data) {
        try {
            ResponseEntity<TeamViewModel> apiResponse = restTemp.postForEntity(apiUrl, data,
                    TeamViewModel.class);
            if (apiResponse.getStatusCode() == HttpStatus.CREATED) {
                System.out.println("New Team added");
                return new ResponseEntity<TeamViewModel>(apiResponse.getBody(), apiResponse.getStatusCode());
            } else {
                throw new Exception("New Team cannot be added");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/edit/{id}")
    ModelAndView edit(@PathVariable Long id) throws Exception {
        ModelAndView view = new ModelAndView("/teams/edit");
        try {
            ResponseEntity<TeamViewModel> apiResponse = restTemp.getForEntity(apiUrl + "/GetById/" + id,
                    TeamViewModel.class);
            if (apiResponse.getStatusCode() == HttpStatus.OK) {
                TeamViewModel cat = apiResponse.getBody();
                view.addObject("roles", RoleTeam.values());
                view.addObject("status", TeamStatus.values());
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
    ResponseEntity<?> update(TeamViewModel data) {
        ResponseEntity<?> apiResponse = null;
        try {
            restTemp.put(apiUrl, data);
            apiResponse = restTemp.getForEntity(apiUrl + "/GetById/" + data.getId(), TeamViewModel.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            apiResponse = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return apiResponse;
    }

    @GetMapping("/delete/{id}")
    ModelAndView GetdataDelete(@PathVariable Long id) throws Exception {
        ModelAndView view = new ModelAndView("/teams/delete");
        try {
            ResponseEntity<TeamViewModel> apiResponse = restTemp.getForEntity(apiUrl + "/GetById/" + id,
                    TeamViewModel.class);
            if (apiResponse.getStatusCode() == HttpStatus.OK) {
                TeamViewModel cat = apiResponse.getBody();
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
    ResponseEntity<?> Delete(TeamViewModel data) {
        ResponseEntity<?> apiResponse = null;
        try {
            apiResponse = restTemp.getForEntity(apiUrl + "/GetById/" + data.getId(), TeamViewModel.class);
            if (apiResponse.getStatusCode() == HttpStatus.OK) {
                restTemp.delete(apiUrl + "/softDelete/" + data.getId());
                apiResponse = new ResponseEntity<String>("Service ID " + data.getId() + " Deleted", HttpStatus.OK);
            } else
                throw new Exception("Team Id " + data.getId() + " cannot be deleted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            apiResponse = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return apiResponse;
    }

}
