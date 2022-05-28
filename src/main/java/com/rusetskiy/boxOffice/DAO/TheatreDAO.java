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

    public void updateRecord(Theatre theatre){
        manager.getTransaction().begin();
        Theatre theatre_to_edit = manager.find(Theatre.class, theatre.getTheatre_id());
        if (!theatre.getTh_name().equals("")){
            theatre_to_edit.setTh_name(theatre.getTh_name());
        }
        if (!theatre.getAddress().equals("")){
            theatre_to_edit.setAddress(theatre.getAddress());
        }
        if (!theatre.getActors().equals("")){
            theatre_to_edit.setActors(theatre.getActors());
        }
        if (!theatre.getDescription().equals("")){
            theatre_to_edit.setDescription(theatre.getDescription());
        }
        if (!theatre.getProducers().equals("")){
            theatre_to_edit.setProducers(theatre.getProducers());
        }
        if (!theatre.getSeats_map_image_url().equals("")){
            theatre_to_edit.setSeats_map_image_url(theatre.getSeats_map_image_url());
        }
        if (!theatre.getTh_image_url().equals("")){
            theatre_to_edit.setTh_image_url(theatre.getTh_image_url());
        }
        manager.getTransaction().commit();
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
