package com.rusetskiy.boxOffice.controllers;

import com.rusetskiy.boxOffice.DAO.PerformanceDAO;
import com.rusetskiy.boxOffice.DAO.TheatreDAO;
import com.rusetskiy.boxOffice.models.Performance;
import com.rusetskiy.boxOffice.models.Theatre;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SingleTheatrePageController {
    @GetMapping("/theatres/theatre")
    public String buildTheatresPage(@RequestParam Integer th_id, Model model){
        TheatreDAO theatreDAO = new TheatreDAO("BoxOffice");
        Theatre theatre = theatreDAO.getRecordByID(th_id);
        model.addAttribute("theatre", theatre);

        PerformanceDAO performanceDAO = new PerformanceDAO("BoxOffice");
        List<Performance> performancesList = performanceDAO.getPerfsListByThId(th_id);
        model.addAttribute("performancesList", performancesList);

        return "theatre.html";
    }
}
