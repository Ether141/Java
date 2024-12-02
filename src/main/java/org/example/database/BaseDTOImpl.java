package org.example.database;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.List;

public abstract class BaseDTOImpl implements BaseDTO {

    public final static String configFileNameDefault = "hibernate.cfg.xml";

    protected SessionFactory sessionFactory;

    public BaseDTOImpl() {
        this(configFileNameDefault);
    }

    public BaseDTOImpl(String configFileName) {
        sessionFactory = new Configuration().configure(configFileName).buildSessionFactory();
    }

    private Session openSession() {
        return sessionFactory.openSession();
    }

    public void saveObject(Object object) {
        try (Session session = openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(object);
            transaction.commit();
        }
    }

    public <T> List<T> loadAllObjects(Class<T> clazz) {
        try (Session session = openSession()) {
            String jpql = "SELECT e FROM %s e".formatted(clazz.getSimpleName());
            TypedQuery<T> query = session.createQuery(jpql, clazz);
            return query.getResultList();
        }
    }

    public boolean doesTableExist(String tableName) {
        try (Session session = openSession()) {
            String sql = "SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = :tableName";

            NativeQuery<Long> query = session.createNativeQuery(sql, Long.class);
            query.setParameter("tableName", tableName.toUpperCase());

            Long count = query.getSingleResult();
            return count != null && count > 0;
        }
    }

    public void close() {
        sessionFactory.close();
    }
}
