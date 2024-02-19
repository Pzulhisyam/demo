package com.example.demo.repositoryImpl;

import com.example.demo.database.EntityManagerFactoryProvider;
import com.example.demo.entity.Client;
import com.example.demo.repository.MemberRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
@Repository
public class MemberRepositoryImpl implements MemberRepository {


    EntityManager entityManager;
    EntityManagerFactory entityManagerFactory;
    @Override
    public List<Client> findByEmailContainingIgnoreCase(String email){
        entityManagerFactory = EntityManagerFactoryProvider.getEntityManagerFactory();
        entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("SELECT e FROM Client e WHERE e.email = :email", Client.class);
        query.setParameter("email", email);
        return query.getResultList();
    }

    @Override
    public List<Client> findActiveRecords(Boolean deleted) {
        entityManagerFactory = EntityManagerFactoryProvider.getEntityManagerFactory();
        entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("SELECT e FROM Client e WHERE e.deleted = :deleted", Client.class);
        query.setParameter("deleted", deleted);

        String queryString = query.unwrap(org.hibernate.query.Query.class).getQueryString();
        System.out.println("SQL query: " + queryString);
        return query.getResultList();
    }
}
