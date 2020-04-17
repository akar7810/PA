package repo;
import entity.Album;
import entity.Artist;
import util.PersistenceUtil;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class AlbumRepository {
	EntityManagerFactory entityManagerFactory= PersistenceUtil.getEntityManageFactory();

    public void create(Album album) {
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(album);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Album findById(int id) {
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
    	Album album = entityManager.find( Album.class, id );
        return album;
    }

    public List<Album> findByName(String name) {
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
        List result = new ArrayList<Album>();
        entityManager.getTransaction().begin();   
        result = entityManager.createNamedQuery( "Album.findByArtist" ).setParameter( "name", name );
        return result.getResultList();
    }

    public List<Albums> findByArtist(Artist artist) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List result = new ArrayList<Album>();
        entityManager.getTransaction().begin();   
        result = entityManager.createNamedQuery( "Album.findByArtist" ).setParameter( "id", artist.getId() );
        return result.getResultList();
    }
}