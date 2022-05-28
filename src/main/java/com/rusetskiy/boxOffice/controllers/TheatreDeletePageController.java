package com.rusetskiy.boxOffice.controllers;

import com.rusetskiy.boxOffice.DAO.TheatreDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TheatreDeletePageController {
    @GetMapping("/theatres/theatre/delete")
    public String buildTheatreAddPage(@RequestParam int th_id, Model model){
        model.addAttribute("th_id", th_id);
        return "theatre_delete.html";
    }

    @PostMapping("/theatres/theatre/delete")
    public String buildTheatreAddPage(@RequestParam int th_id){
        TheatreDAO theatreDAO = new TheatreDAO("BoxOffice");
        theatreDAO.deleteRecordByID(th_id);
        return "redirect:/theatres";
    }
}
