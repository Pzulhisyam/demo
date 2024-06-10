package com.example.demo.service;

import com.example.demo.entity.Client;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repositoryImpl.MemberRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;
    List <Client> listClient;

    public List<Client> searchByEmail(String email){
        memberRepository = new MemberRepositoryImpl();
        listClient = memberRepository.findByEmailContainingIgnoreCase(email);
        if (Objects.isNull(listClient)) {
            throw new ResourceNotFoundException(Client.class, null);
        }
        return listClient;
    }

    public List<Client> searchActiveRecords(){
        memberRepository = new MemberRepositoryImpl();
        listClient = memberRepository.findActiveRecords(true);
        if(Objects.isNull(listClient)){
            throw  new ResourceNotFoundException(Client.class, null);
        }
        return listClient;
    }
}
