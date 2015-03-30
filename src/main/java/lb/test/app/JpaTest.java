package lb.test.app;

/**
 * Created by root on 27.03.2015.
 */
import lb.test.dao.CategoryDao;
import lb.test.dao.Dao;
import lb.test.dao.lb.test.dao.util.DaoFactory;
import lb.test.entity.Category;
import lb.test.entity.Persistent;
import lb.test.entity.Product;
import lb.test.entity.SearchedObject;
import lb.test.util.FindObjectService;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@SuppressWarnings("unchecked")
public class JpaTest {
  EntityManager manager;
    /**
     * @param args
     */
    public static void main(String[] args) {
        Random r = new Random();
        Category abc = new Category("abc"+r.nextInt(1000));
        DaoFactory.DAO_INSTANCE.getDao(abc).add(abc);
        Persistent product = new Product("Solo3asdhs2"+r.nextInt(1000), abc, 10000f);
        Dao dao = DaoFactory.DAO_INSTANCE.getDao(product);
        dao.add(product);


    }
}
