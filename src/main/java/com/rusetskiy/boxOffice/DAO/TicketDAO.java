package com.rusetskiy.boxOffice.DAO;


import com.rusetskiy.boxOffice.models.Ticket;

import javax.persistence.*;
import java.util.List;

public class TicketDAO {
    EntityManager manager;

    public TicketDAO(String persistenceUnitName){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceUnitName);
        manager = factory.createEntityManager();
    }

    public Ticket getRecordByID(int TicketID) throws IllegalArgumentException{
        manager.getTransaction().begin();
        Ticket ticket = manager.find(Ticket.class, TicketID);
        manager.getTransaction().commit();
        return ticket;
    }

    public List<Ticket> getTicketsList(){
        manager.getTransaction().begin();
        List<Ticket> ticketsList = manager.createNativeQuery("Select * from tickets;", Ticket.class).getResultList();
        manager.getTransaction().commit();
        return ticketsList;
    }

    public int putRecord(Ticket ticket) throws EntityExistsException, IllegalArgumentException, TransactionRequiredException {
        manager.getTransaction().begin();
        manager.persist(ticket);
        int id = ticket.getTick_id();
        manager.getTransaction().commit();
        return id;
    }

    public Ticket deleteRecordByID(int TicketID) throws IllegalArgumentException, TransactionRequiredException{
        manager.getTransaction().begin();
        Ticket ticket = manager.find(Ticket.class, TicketID);
        manager.remove(ticket);
        manager.getTransaction().commit();
        return ticket;
    }

}
