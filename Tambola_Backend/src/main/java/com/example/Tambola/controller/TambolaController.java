package com.example.Tambola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Tambola.entity.Tambola;
import com.example.Tambola.repository.TambolaRepository;
import com.example.Tambola.service.TambolaService;





@RestController
@RequestMapping("/api/tambola")
public class TambolaController {
    @Autowired
    private TambolaService tambolaService;

    @Autowired
    private TambolaRepository tambolaRepository;
    



    @GetMapping("/ticket")
    public Tambola getTicket(Tambola t) {
        String ticket[][] = tambolaService.generateTambolaTicket();
        t.setTicket(ticket);
        tambolaRepository.save(t);
        return t;
    }

    @GetMapping("/ticket/get")
    public List<Tambola> getTicketById() {
        return tambolaRepository.findAll();
    }
}
