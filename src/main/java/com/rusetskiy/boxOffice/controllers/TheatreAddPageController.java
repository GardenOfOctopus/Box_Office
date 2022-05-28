package com.rusetskiy.boxOffice.controllers;

import com.rusetskiy.boxOffice.DAO.TheatreDAO;
import com.rusetskiy.boxOffice.MyTypes.MyJson;
import com.rusetskiy.boxOffice.models.Theatre;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TheatreAddPageController {
    @GetMapping("/theatres/add")
    public String buildTheatreAddPage(){
        return "theatre_add.html";
    }

    @PostMapping("/theatres/add")
    public String AddNewTheatrePage(@RequestParam(name = "th_name") String th_name,
                                    @RequestParam(name = "address", required = false) String address,
                                    @RequestParam(name = "producers", required = false) String producers,
                                    @RequestParam(name = "actors", required = false) String actors,
                                    @RequestParam(name = "th_image_url", required = false) String th_image_url,
                                    @RequestParam(name = "seats_map_image_url", required = false) String seats_map_image_url,
                                    @RequestParam(name = "description", required = false) String description) {

        TheatreDAO theatreDAO = new TheatreDAO("BoxOffice");
        Theatre theatre = new Theatre(th_name, address, producers, actors, null, th_image_url, seats_map_image_url, description);
        theatreDAO.putRecord(theatre);
        return "redirect:/theatres";
    }
}
