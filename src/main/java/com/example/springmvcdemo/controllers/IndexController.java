package com.example.springmvcdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping(value="/")
    public String index (Model model) {

        model.addAttribute("message", "Hello World");
        model.addAttribute("pageTitle", "Main");
        model.addAttribute("currentPage", "index");

        return "index";
    }
}
