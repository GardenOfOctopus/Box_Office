package com.rusetskiy.boxOffice.DAO;

import com.rusetskiy.boxOffice.models.Event;
import com.rusetskiy.boxOffice.models.Theatre;

import javax.persistence.*;
import java.util.List;

public class EventDAO{
    EntityManager manager;

    public EventDAO(String persistenceUnitName){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceUnitName);
        manager = factory.createEntityManager();
    }

    public Event getRecordByID(int EventID) throws IllegalArgumentException{
        manager.getTransaction().begin();
        Event event = manager.find(Event.class, EventID);
        manager.getTransaction().commit();
        return event;
    }

    public List<Event> getEventsList(){
        manager.getTransaction().begin();
        List<Event> eventsList = manager.createNativeQuery("Select * from events;", Event.class).getResultList();
        manager.getTransaction().commit();
        return eventsList;
    }

    public int putRecord(Event event) throws EntityExistsException, IllegalArgumentException, TransactionRequiredException {
        manager.getTransaction().begin();
        manager.persist(event);
        int id = event.getEv_id();
        manager.getTransaction().commit();
        return id;
    }

    public Event deleteRecordByID(int EventID) throws IllegalArgumentException, TransactionRequiredException{
        manager.getTransaction().begin();
        Event event = manager.find(Event.class, EventID);
        manager.remove(event);
        manager.getTransaction().commit();
        return event;
    }
}
