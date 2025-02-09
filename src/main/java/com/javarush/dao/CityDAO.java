package com.javarush.dao;

import com.javarush.domian.City;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.util.List;

public class CityDAO {
    private final SessionFactory sessionFactory;

    public CityDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<City> getItems(int offset, int limit) {
        String hql = "select c from City c";
        Query<City> query = sessionFactory.getCurrentSession().createQuery(hql, City.class);

        query.setFirstResult(offset);
        query.setMaxResults(limit);

        return query.list();
    }

    public int getTotalCount() {
        String hql = "select count(c) from City c";
        Query<Long> query = sessionFactory.getCurrentSession().createQuery(hql, Long.class);
        return Math.toIntExact(query.uniqueResult());
    }

    public City getById(Integer id) {
        String hql = "select c from City c join fetch c.country where c.id = :ID";
        Query<City> query = sessionFactory.getCurrentSession().createQuery(hql, City.class);
        query.setParameter("ID", id);
        return query.getSingleResult();
    }
}
