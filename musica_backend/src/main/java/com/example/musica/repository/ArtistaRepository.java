package com.example.musica.repository;

import com.example.musica.models.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistaRepository extends JpaRepository<Artista, Integer> {
}