package com.rusetskiy.boxOffice.controllers;


import com.rusetskiy.boxOffice.DAO.EventDAO;
import com.rusetskiy.boxOffice.DAO.PerformanceDAO;
import com.rusetskiy.boxOffice.models.Event;
import com.rusetskiy.boxOffice.models.Performance;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SinglePerfomancePageController {
    @GetMapping("/performances/performance")
    public String buildSinglePerformancePage(@RequestParam Integer perf_id, Model model){
        PerformanceDAO performanceDAO = new PerformanceDAO("BoxOffice");
        Performance performance = performanceDAO.getRecordByID(perf_id);

        EventDAO eventDAO = new EventDAO("BoxOffice");
        List<Event> perf_events = eventDAO.getEventsListByPerfId(perf_id);

        model.addAttribute("performance", performance);
        model.addAttribute("perf_events", perf_events);
        return "performance.html";
    }
}
