package com.example.demo.repository;

import com.example.demo.entity.Client;
import com.example.demo.repositoryImpl.MemberRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;
import java.util.List;


public interface MemberRepository  {

    List<Client> findByEmailContainingIgnoreCase(String email);
    List<Client> findActiveRecords (Boolean deleted);
}
