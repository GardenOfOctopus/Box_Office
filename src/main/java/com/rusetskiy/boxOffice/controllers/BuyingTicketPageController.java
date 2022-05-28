package com.rusetskiy.boxOffice.controllers;

import com.rusetskiy.boxOffice.DAO.TheatreDAO;
import com.rusetskiy.boxOffice.DAO.TicketDAO;
import com.rusetskiy.boxOffice.models.Theatre;
import com.rusetskiy.boxOffice.models.Ticket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BuyingTicketPageController {
    @GetMapping("/buy_ticket")
    public String buildBuyingTicketPage(@RequestParam Integer ev_id, Model model){
        TicketDAO ticketDAO = new TicketDAO("BoxOffice");
        List<Ticket> ticketsList= ticketDAO.getTicketsListByEvId(ev_id);
        model.addAttribute("ticketsList", ticketsList);
        return "buy_ticket.html";
    }

    @PostMapping("/buy_ticket")
    public String finishBuyingTicket(@RequestParam (name = "ticket") String ticket,
                                     @RequestParam (name = "bank_account_number") String bank_account_number){
        return "success.html";
    }
}
