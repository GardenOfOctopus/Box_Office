package com.rusetskiy.boxOffice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {
    @GetMapping("/")
    public String buildMainPage(Model model){
        return "main_page.html";
    }
}
