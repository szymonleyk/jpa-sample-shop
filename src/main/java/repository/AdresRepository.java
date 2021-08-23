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

//    public Adres findByStreet(String street) {
//        entityManager = emf.createEntityManager();
//
//        entityManager.close();
//    }
}
