package lb.test.util;

import lb.test.dao.SearchedObjectDao;
import lb.test.entity.SearchedObject;

import java.util.List;

/**
 * Created by root on 29.03.2015.
 */
public final class FindObjectService {
       public static List<SearchedObject> findAllByRequest(final String category,
                                                           final String name,
                                                           final String priceLowerBound,
                                                           final String priceUpperBound) {

              return SearchedObjectDao.getAllFoundByRequest(category, name, priceLowerBound, priceUpperBound);
       }
    public static List<SearchedObject> simplyGetAll(){
        return SearchedObjectDao.getAll();
    }
}
