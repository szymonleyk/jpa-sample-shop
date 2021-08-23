package repository;

import entity.Adres;

import javax.persistence.*;
import java.util.List;

public class AdresRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("sklep-persistence-unit");
    EntityManager entityManager;

    public Adres getById(int id) {
        entityManager = emf.createEntityManager();
        Adres adres = entityManager.find(Adres.class, id);
        entityManager.close();
        return adres;
    }

    public void save(Adres adres1) {
        entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(adres1);
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

            Adres adres = entityManager.find(Adres.class, id);
            entityManager.remove(adres);

            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
        }
        entityManager.close();
    }

    public List<Adres> getAll() {
        entityManager = emf.createEntityManager();

        TypedQuery<Adres> query = entityManager.createQuery("SELECT a FROM Adres a", Adres.class);
        List<Adres> addresses = query.getResultList();

        entityManager.close();

        return addresses;
    }

    public List<Adres> findByStreet(String street) {
        entityManager = emf.createEntityManager();

        // łączenie stringów
        // TypedQuery<Adres> query = entityManager.createQuery("SELECT a FROM Adres a WHERE a.ulica = '"+street+"'", Adres.class);

        // parametry indeksowe
//        TypedQuery<Adres> query = entityManager.createQuery("SELECT a FROM Adres a WHERE a.ulica = ?1 OR a.nrDomu = ?2", Adres.class);
//        query.setParameter(1, street);
//        query.setParameter(2, "5");

        // parametry nazwane
        TypedQuery<Adres> query = entityManager.createQuery("SELECT a FROM Adres a WHERE a.ulica = :ulica OR a.nrDomu = :nrDomu", Adres.class);
        query.setParameter("ulica", street);
        query.setParameter("nrDomu", "5");

        List<Adres> addresses = query.getResultList();

        entityManager.close();

        return addresses;
    }

    public void removeByStreet(String street) {
        entityManager = emf.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Query query = entityManager.createQuery("DELETE FROM Adres a WHERE a.ulica = :ulica");
            query.setParameter("ulica", street);
            query.executeUpdate();

            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
        }

        entityManager.close();
    }
}
