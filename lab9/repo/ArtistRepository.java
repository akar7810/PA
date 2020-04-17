package repo;
import entity.Artist;
import util.PersistenceUtil;

import javax.persistence.*;
import java.util.List;

public class ArtistRepository {
	EntityManagerFactory entityManagerFactory= PersistenceUtil.getEntityManageFactory();
	
    public void create(Artist artist) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(artist);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Artist findById(int id) {
        EntityManager entityManager = EntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Artist artist = entityManager.find(Artist.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return artist;

    }

    public List<Artist> findByName(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Artist> query = entityManager.createNamedQuery("Artist.findByName", Artist.class);
        query.setParameter("name", name);
        Artist result = query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;

    }
}