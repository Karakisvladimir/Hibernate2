package org.example.crudServise;

import org.example.entity.Ticket;
import org.example.storage.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

public class TicketCrudService {
    private static final String GET_ALL_TICKET_QUERY = "FROM Ticket";


    public boolean create(Ticket ticket) {
        boolean result = false;

        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            try {
                ticket.setId(null);
                session.persist(ticket);
                transaction.commit();
                result = true;
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
            }
        }

        return result;
    }


    public boolean update(Ticket ticket) {
        boolean result = false;

        if (Objects.isNull(ticket.getId())) {
            return false;
        }

        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            try {
                session.merge(ticket);
                transaction.commit();
                result = true;
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
            }
        }

        return result;
    }


    public Ticket getById(Long id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.get(Ticket.class, id);
        }
    }


    public List<Ticket> getAll() {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.createQuery(GET_ALL_TICKET_QUERY, Ticket.class).list();
        }
    }


    public void deleteById(Long id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Ticket existing = session.get(Ticket.class, id);
            session.remove(existing);
            transaction.commit();
        }
    }


    public void delete(Ticket ticket) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(ticket);
            transaction.commit();
        }
    }
}

