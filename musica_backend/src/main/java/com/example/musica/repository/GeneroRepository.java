package com.example.musica.repository;

import com.example.musica.models.Genero;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GeneroRepository extends JpaRepository<Genero, Integer> {
}