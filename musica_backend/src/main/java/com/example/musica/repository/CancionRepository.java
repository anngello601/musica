package com.example.musica.repository;

import com.example.musica.models.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CancionRepository extends JpaRepository<Cancion, Integer> {
    List<Cancion> findByTituloContainingIgnoreCase(String titulo);
}