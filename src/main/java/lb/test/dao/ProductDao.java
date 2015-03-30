package lb.test.dao;

import lb.test.entity.Category;
import lb.test.entity.Persistent;
import lb.test.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by root on 30.03.2015.
 */
public class ProductDao implements Dao<Product> {
    private  EntityManager manager;
    private  EntityTransaction transaction;
    private CategoryDao categoryDao = new CategoryDao();

    public ProductDao() {
        manager = getEntityManager();
        transaction = manager.getTransaction();
    }
    @Override
    public void add(Product persistent) {
        transaction.begin();
        manager.merge(persistent);
        transaction.commit();
    }

    public void add(String categoryName, Product persistent){
        Category category = categoryDao.getByName(categoryName);
        System.out.println(category.getName()+" "+ category.getId());
        persistent = new Product(persistent.getProductName(),category,persistent.getPrice());
        transaction.begin();
        manager.persist(persistent);
        transaction.commit();
    }

    @Override
    public void delete() {

    }

    @Override
    public EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory("persistenceUnit").createEntityManager();
    }
}
