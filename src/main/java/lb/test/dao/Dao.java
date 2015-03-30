package lb.test.dao;

import lb.test.entity.Persistent;

import javax.persistence.EntityManager;

/**
 * Created by root on 30.03.2015.
 */
public interface Dao<T extends Persistent> {
       void add(T persistent);
       void delete();
       EntityManager getEntityManager();
}
