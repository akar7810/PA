package util;

import javax.persistence.*;

public class PersistenceUtil {
    static EntityManagerFactory entityManagerFactory;

    public static EntityManagerFactory getEntityManageFactory() {

        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("MusicAlbumsPU");
        }
        return entityManagerFactory;

    }

}