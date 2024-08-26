package com.example.Tambola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Tambola.entity.Tambola;


public interface  TambolaRepository extends JpaRepository<Tambola, Integer>{
    
}
