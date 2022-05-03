package com.rusetskiy.boxOffice.DAO;

import com.rusetskiy.boxOffice.models.Theatre;

import javax.persistence.*;
import java.util.List;


public class TheatreDAO {
    EntityManager manager;

    public TheatreDAO(String persistenceUnitName){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceUnitName);
        manager = factory.createEntityManager();
    }

    public Theatre getRecordByID(int TheatreID) throws IllegalArgumentException{
        manager.getTransaction().begin();
        Theatre theatre = manager.find(Theatre.class, TheatreID);
        manager.getTransaction().commit();
        return theatre;
    }

    public List<Theatre> getTheatresList(){
        manager.getTransaction().begin();
        List<Theatre> theatresList = manager.createNativeQuery("Select * from theatres;", Theatre.class).getResultList();
        manager.getTransaction().commit();
        return theatresList;
    }

    public int putRecord(Theatre theatre) throws EntityExistsException, IllegalArgumentException, TransactionRequiredException {
        manager.getTransaction().begin();
        manager.persist(theatre);
        int id = theatre.getTheatre_id();
        manager.getTransaction().commit();
        return id;
    }

    public Theatre deleteRecordByID(int TheatreID) throws IllegalArgumentException, TransactionRequiredException{
        manager.getTransaction().begin();
        Theatre theatre = manager.find(Theatre.class, TheatreID);
        manager.remove(theatre);
        manager.getTransaction().commit();
        return theatre;
    }

}
