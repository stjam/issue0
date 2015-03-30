package lb.test.dao;

import lb.test.entity.SearchedObject;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by root on 29.03.2015.
 */
public final class SearchedObjectDao{
    private static SearchedObject daoInstance = new SearchedObject();
    private SearchedObjectDao(){

    }
    public static List<SearchedObject> getAll() {
          final Query query = getEntityManager().createNativeQuery(
                  "SELECT cat.name,  prod.price, prod.productName " +
                  "FROM cat JOIN prod WHERE cat.id=prod.cat_id",
                  SearchedObject.class);

        return query.getResultList();
    }
    public static List<SearchedObject> getAllFoundByRequest(final String category,
                                                            final String name,
                                                            final String priceLowerBound,
                                                            final String priceUpperBound){
        StringBuilder request = new StringBuilder();
        if(category != null && category.length() > 0) {
            request.append(" AND cat.name ='" + category.toLowerCase() + "'");
        }
        if(name != null && name.length() > 0) {
            request.append(" AND prod.productName ='" + name.toLowerCase() + "'");
        }
        if(priceLowerBound != null && priceLowerBound.length() > 0) {
            request.append(" AND prod.price >= '" + priceLowerBound + "'");
        }
        if(priceUpperBound != null && priceUpperBound.length() > 0) {
            request.append(" AND prod.price <='" + priceUpperBound + "'");
        }
        final Query query = getEntityManager().createNativeQuery(
                "SELECT cat.name,  prod.price, prod.productName " +
                        "FROM cat JOIN prod WHERE cat.id=prod.cat_id "+request,
                SearchedObject.class);
           return query.getResultList();
    }
    private static EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory("persistenceUnit").createEntityManager();
    }

}
