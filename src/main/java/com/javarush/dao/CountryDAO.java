package com.javarush.dao;

import com.javarush.domian.Country;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.util.List;

public class CountryDAO {

    private final SessionFactory sessionFactory;

    public CountryDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Country> getAll() {
//        String hql = "select c from Country c";
        String hql = "select c from Country c join fetch c.languages";

        Query<Country> query = sessionFactory.getCurrentSession().createQuery(hql, Country.class);

        return query.list();
    }
}
