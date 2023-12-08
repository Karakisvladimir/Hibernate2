package org.example.crudServise;

import org.example.entity.Planet;
import org.example.storage.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

public class PlanetCrudService {
    private static final String GET_ALL_PLANET_QUERY = "FROM Planet";


    public boolean createPlanet(Planet planet) {
        boolean result = false;

        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            try {
                session.persist(planet);
                transaction.commit();
                result = true;
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
            }
        }

        return result;
    }


    public boolean updatePlanet(Planet planet) {
        boolean result = false;

        if (Objects.isNull(planet.getId())) {
            return false;
        }

        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            try {
                session.merge(planet);
                transaction.commit();
                result = true;
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
            }
        }

        return result;
    }


    public Planet getPlanetById(String planetId) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.get(Planet.class, planetId);
        }
    }


    public List<Planet> getAllPlanets() {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.createQuery(GET_ALL_PLANET_QUERY, Planet.class).list();
        }
    }


    public void deletePlanetById(String planetId) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Planet existing = session.get(Planet.class, planetId);
            session.remove(existing);
            transaction.commit();
        }
    }


    public void deletePlanet(Planet planet) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(planet);
            transaction.commit();
        }
    }
}

