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
        //test branching
        entityManagerFactory = EntityManagerFactoryProvider.getEntityManagerFactory();
        entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("SELECT e FROM Client e WHERE e.email = :email", Client.class);
        query.setParameter("email", email);
        return query.getResultList();
    }
}
