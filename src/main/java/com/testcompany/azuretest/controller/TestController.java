package com.testcompany.azuretest.controller;

import com.testcompany.azuretest.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/")
    public String index(Model model) {
        Optional<String> message = testService.getMessage();
        if (message.isPresent()) {
            model.addAttribute("message", message.get());
        }
        return "index";
    }
}
