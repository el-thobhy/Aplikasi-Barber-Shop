package com.elthobhy.barbershop.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping("/")
    ModelAndView Index() {
        return new ModelAndView("/index");
    }

}