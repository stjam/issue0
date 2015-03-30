package lb.test.dao;

import lb.test.entity.Category;
import javax.persistence.*;

/**
 * Created by root on 30.03.2015.
 */
public class CategoryDao implements Dao<Category> {
    private  EntityManager manager;
    private  EntityTransaction transaction;

    public CategoryDao() {
            manager = getEntityManager();
            transaction = manager.getTransaction();
    }
    @Override
    public void add(Category persistent) {

         transaction.begin();
         manager.persist(persistent);
         transaction.commit();

    }

    public Category getByName(final String categoryName) {
        Category cat =(Category) manager.createNativeQuery("SELECT cat.id, cat.name " +
                "from cat where cat.name = '"+categoryName+"'", Category.class).getSingleResult();
        return cat;
    }

    @Override
    public void delete() {

    }

    @Override
    public EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory("persistenceUnit").createEntityManager();
    }
}
