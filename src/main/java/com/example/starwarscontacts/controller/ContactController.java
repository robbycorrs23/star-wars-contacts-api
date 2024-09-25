package com.example.starwarscontacts.controller;

import com.example.starwarscontacts.model.Contact;
import com.example.starwarscontacts.repository.ContactRepository;
import com.example.starwarscontacts.service.SwapiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    private final ContactRepository contactRepository;
    private final SwapiService swapiService;

    public ContactController(ContactRepository contactRepository, SwapiService swapiService) {
        this.contactRepository = contactRepository;
        this.swapiService = swapiService;
    }

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @PostMapping
    public Contact createContact(@RequestBody Contact contact) {
        return contactRepository.save(contact);
    }

    @GetMapping("/search")
    public ResponseEntity<String> searchCharacter(@RequestParam String name) {
        String result = swapiService.searchCharacter(name);
        return ResponseEntity.ok(result);
    }
}
