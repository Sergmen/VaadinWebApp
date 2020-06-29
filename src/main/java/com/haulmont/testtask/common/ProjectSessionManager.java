package com.haulmont.testtask.common;

import org.hibernate.Session;

import javax.persistence.*;

public class ProjectSessionManager {

    protected Session session;

    public Session getSession() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceCore" );
        EntityManager em = factory.createEntityManager();
        session =  em.unwrap(Session.class);

        return session;
    }
}



