package com.example.EteBackend.repository;


import com.example.EteBackend.model.UserDetails;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class UserRepository {

    @PersistenceUnit(unitName = "Backendtest")
    private EntityManagerFactory entityManagerFactory;

    public boolean register(UserDetails newUser) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(newUser);
            transaction.commit();
            return true;

        } catch (Exception e) {

            System.out.println(e.getMessage());
            transaction.rollback();
            return false;
        }
    }
    public UserDetails checkCredentials(String username) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            TypedQuery<UserDetails> query = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username", UserDetails.class);
            query.setParameter("username", username);
            return query.getSingleResult();

        } catch (NoResultException e) {
            return null;
        }
    }

}


