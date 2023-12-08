package org.example.crudServise;

import org.example.entity.Client;
import org.example.storage.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

public class ClientCrudService {

    private static final String GET_ALL_CLIENT_QUERY = "FROM Client";


    public boolean createClient(Client client) {
        boolean result = false;

        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            try {
                client.setId(null);
                session.persist(client);
                transaction.commit();
                result = true;
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
            }
        }

        return result;
    }


    public boolean updateClient(Client client) {
        boolean result = false;

        if (Objects.isNull(client.getId())) {
            return false;
        }

        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            try {
                session.merge(client);
                transaction.commit();
                result = true;
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
            }
        }

        return result;
    }


    public Client getClientById(Long clientId) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.get(Client.class, clientId);
        }
    }


    public List<Client> getAllClients() {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.createQuery(GET_ALL_CLIENT_QUERY, Client.class).list();
        }
    }


    public void deleteClientById(Long clientId) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Client existing = session.get(Client.class, clientId);
            session.remove(existing);
            transaction.commit();
        }
    }


    public void deleteClient(Client client) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(client);
            transaction.commit();
        }
    }
}

