import entity.Adres;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ShopExample {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sklep-persistence-unit");
        EntityManager entityManager = emf.createEntityManager();

        // pobieranie po id
        Adres adres = entityManager.find(Adres.class, 4);
        System.out.println(adres);


        // zapis
        Adres adres1 = new Adres("Fioletowa", "22", 4, "23-123", "Dąbrowa");

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(adres1);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
        }
        

        entityManager.close();
    }
}
