package lb.test.dao.lb.test.dao.util;

import lb.test.dao.CategoryDao;
import lb.test.dao.Dao;
import lb.test.dao.ProductDao;
import lb.test.entity.Category;
import lb.test.entity.Persistent;
import lb.test.entity.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 30.03.2015.
 */
public final class DaoFactory {
    private static Map<String, Dao> map;
    public final static DaoFactory DAO_INSTANCE = new DaoFactory();
    private DaoFactory() {
       map = getHash();
    }
    public Dao getDao(Persistent persistent) {
        return map.get(persistent.getClass().getName());
    }
    private Map getHash(){
        final Map map = new HashMap();
        map.put(Category.class.getName(), new CategoryDao());
        map.put(Product.class.getName(), new ProductDao());
        return map;
    }
}
