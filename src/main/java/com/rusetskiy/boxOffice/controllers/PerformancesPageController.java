package com.rusetskiy.boxOffice.controllers;

import com.rusetskiy.boxOffice.DAO.PerformanceDAO;
import com.rusetskiy.boxOffice.models.Performance;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PerformancesPageController {
    @GetMapping("/performances")
    public String buildPerformancesPage(Model model){
        PerformanceDAO performanceDAO = new PerformanceDAO("BoxOffice");
        List<Performance> performancesList = performanceDAO.getPerformancesList();
        model.addAttribute("performancesList", performancesList);
        return "performances.html";
    }
}