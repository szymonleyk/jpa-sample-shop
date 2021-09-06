package repository;

import entity.Zamowienie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ZamowienieRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("sklep-persistence-unit");
    EntityManager entityManager;

    public Zamowienie getById(int id) {
        entityManager = emf.createEntityManager();
        Zamowienie zamowienie = entityManager.find(Zamowienie.class, id);
        entityManager.close();
        return zamowienie;
    }

    public void save(Zamowienie zamowienie1) {
        entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(zamowienie1);
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

            Zamowienie zamowienie = entityManager.find(Zamowienie.class, id);
            entityManager.remove(zamowienie);

            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
        }
        entityManager.close();
    }

    public List<Zamowienie> getAll() {
        entityManager = emf.createEntityManager();

        TypedQuery<Zamowienie> query = entityManager.createQuery("SELECT a FROM Zamowienie a", Zamowienie.class);
        List<Zamowienie> addresses = query.getResultList();

        entityManager.close();

        return addresses;
    }
}
