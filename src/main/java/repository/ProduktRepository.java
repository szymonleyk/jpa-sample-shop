package repository;

import entity.Produkt;

import javax.persistence.*;
import java.util.List;

public class ProduktRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("sklep-persistence-unit");
    EntityManager entityManager;

    public Produkt getById(int id) {
        entityManager = emf.createEntityManager();
        Produkt produkt = entityManager.find(Produkt.class, id);
        entityManager.close();
        return produkt;
    }

    public void save(Produkt produkt1) {
        entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(produkt1);
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

            Produkt produkt = entityManager.find(Produkt.class, id);
            entityManager.remove(produkt);

            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
        }
        entityManager.close();
    }

    public List<Produkt> getAll() {
        entityManager = emf.createEntityManager();

        TypedQuery<Produkt> query = entityManager.createQuery("SELECT a FROM Produkt a", Produkt.class);
        List<Produkt> addresses = query.getResultList();

        entityManager.close();

        return addresses;
    }
}
