package com.example.Tambola.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Tambola {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;
    String ticket[][];
    
}
