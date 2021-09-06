package repository;

import entity.PozycjeZamowienia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class PozycjeZamowieniaRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("sklep-persistence-unit");
    EntityManager entityManager;

    public PozycjeZamowienia getById(int id) {
        entityManager = emf.createEntityManager();
        PozycjeZamowienia pozycjeZamowienia = entityManager.find(PozycjeZamowienia.class, id);
        entityManager.close();
        return pozycjeZamowienia;
    }

    public void save(PozycjeZamowienia pozycjeZamowienia1) {
        entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pozycjeZamowienia1);
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

            PozycjeZamowienia pozycjeZamowienia = entityManager.find(PozycjeZamowienia.class, id);
            entityManager.remove(pozycjeZamowienia);

            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
        }
        entityManager.close();
    }

    public List<PozycjeZamowienia> getAll() {
        entityManager = emf.createEntityManager();

        TypedQuery<PozycjeZamowienia> query = entityManager.createQuery("SELECT a FROM PozycjeZamowienia a", PozycjeZamowienia.class);
        List<PozycjeZamowienia> addresses = query.getResultList();

        entityManager.close();

        return addresses;
    }
}
