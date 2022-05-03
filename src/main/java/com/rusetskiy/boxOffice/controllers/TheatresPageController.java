package com.rusetskiy.boxOffice.controllers;

import com.rusetskiy.boxOffice.DAO.TheatreDAO;
import com.rusetskiy.boxOffice.models.Theatre;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TheatresPageController {
    @GetMapping("/theatres")
    public String buildTheatresPage(Model model){
        TheatreDAO theatreDAO = new TheatreDAO("BoxOffice");
        List<Theatre> theatresList = theatreDAO.getTheatresList();
        model.addAttribute("theatresList", theatresList);
        return "theatres.html";
    }

}
