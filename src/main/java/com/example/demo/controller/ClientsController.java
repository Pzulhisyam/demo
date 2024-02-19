package com.example.demo.controller;

import com.example.demo.entity.Client;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.MemberService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/clients")
public class ClientsController {
    private final ClientRepository clientRepository;
    private MemberService memberService;

    public ClientsController(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public List<Client> getClients(){
        memberService = new MemberService();
        return memberService.searchActiveRecords();
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable Long id){

        Client client = clientRepository.findById(id).orElseThrow(()-> new RuntimeException("Employee not exist with id"+id));
        return client;
    }

    @GetMapping("/searchByEmail")
    public List<Client> searchByEmail(@RequestParam String email){
        memberService = new MemberService();
        return memberService.searchByEmail(email);
    }

    @PostMapping
    public ResponseEntity createClient(@RequestBody Client client) throws URISyntaxException{
        Client savedClient = clientRepository.save(client);
        return ResponseEntity.created(new URI("/clients/" +savedClient.getId())).body(savedClient);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateClient(@PathVariable Long id, @RequestBody Client client){
        Client currentClient = clientRepository.findById(id).orElseThrow(RuntimeException::new);
        currentClient.setName(client.getName());
        currentClient.setEmail(client.getEmail());
        currentClient = clientRepository.save(currentClient);

        return ResponseEntity.ok(currentClient);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id){
        clientRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/greet")
    public String greet() {
        return "Hello, World!";
    }

}
