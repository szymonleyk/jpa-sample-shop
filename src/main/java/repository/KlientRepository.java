package repository;

import entity.Klient;

import javax.persistence.*;
import java.util.List;

public class KlientRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("sklep-persistence-unit");
    EntityManager entityManager;

    public Klient getById(int id) {
        entityManager = emf.createEntityManager();
        Klient kllient = entityManager.find(Klient.class, id);
        entityManager.close();
        return kllient;
    }

    public void save(Klient klient) {
        entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(klient);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
        }
        entityManager.close();
    }

    public void remove(int id) {
        entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            Klient kllient = entityManager.find(Klient.class, id);
            entityManager.remove(kllient);

            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
        }
        entityManager.close();
    }

    public List<Klient> getAll() {
        entityManager = emf.createEntityManager();

        TypedQuery<Klient> query = entityManager.createQuery("SELECT a FROM Klient a", Klient.class);
        List<Klient> klients = query.getResultList();

        entityManager.close();

        return klients;
    }

    public List<Klient> findByName(String name) {
        entityManager = emf.createEntityManager();

        // łączenie stringów
        // TypedQuery<Klient> query = entityManager.createQuery("SELECT a FROM Klient a WHERE a.ulica = '"+street+"'", Klient.class);

        // parametry indeksowe
//        TypedQuery<Klient> query = entityManager.createQuery("SELECT a FROM Klient a WHERE a.ulica = ?1 OR a.nrDomu = ?2", Klient.class);
//        query.setParameter(1, street);
//        query.setParameter(2, "5");

        // parametry nazwane
        TypedQuery<Klient> query = entityManager.createQuery("SELECT a FROM Klient a WHERE a.imie = :imie", Klient.class);
        query.setParameter("imie", name);

        List<Klient> klients = query.getResultList();

        entityManager.close();

        return klients;
    }

    public void removeBySurname(String surname) {
        entityManager = emf.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Query query = entityManager.createQuery("DELETE FROM Klient a WHERE a.nazwisko = :nazwisko");
            query.setParameter("nazwisko", surname);
            query.executeUpdate();

            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
        }

        entityManager.close();
    }
}
