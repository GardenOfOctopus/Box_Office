package com.rusetskiy.boxOffice.DAO;

import com.rusetskiy.boxOffice.models.Performance;

import javax.persistence.*;
import java.util.List;

public class PerformanceDAO {
    EntityManager manager;

    public PerformanceDAO(String persistenceUnitName){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceUnitName);
        manager = factory.createEntityManager();
    }

    public Performance getRecordByID(int PerformanceID) throws IllegalArgumentException{
        manager.getTransaction().begin();
        Performance performance = manager.find(Performance.class, PerformanceID);
        manager.getTransaction().commit();
        return performance;
    }

    public List<Performance> getPerformancesList(){
        manager.getTransaction().begin();
        List<Performance> performancesList = manager.createNativeQuery("Select * from performances;", Performance.class).getResultList();
        manager.getTransaction().commit();
        return performancesList;
    }

    public int putRecord(Performance performance) throws EntityExistsException, IllegalArgumentException, TransactionRequiredException {
        manager.getTransaction().begin();
        manager.persist(performance);
        int id = performance.getPerf_id();
        manager.getTransaction().commit();
        return id;
    }

    public Performance deleteRecordByID(int PerformanceID) throws IllegalArgumentException, TransactionRequiredException{
        manager.getTransaction().begin();
        Performance performance = manager.find(Performance.class, PerformanceID);
        manager.remove(performance);
        manager.getTransaction().commit();
        return performance;
    }

}
