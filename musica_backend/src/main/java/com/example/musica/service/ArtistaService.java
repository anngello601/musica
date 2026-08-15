package com.example.musica.service;

import com.example.musica.models.Artista;
import com.example.musica.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistaService {

    @Autowired
    private ArtistaRepository artistaRepository;

    
    public ArtistaService(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }

    public List<Artista> obtenerTodos() {
        return artistaRepository.findAll();
    }

    public Optional<Artista> obtenerPorId(Integer id) {
        return artistaRepository.findById(id);
    }

    public Artista guardar(Artista artista) {
        return artistaRepository.save(artista);
    }

    public void eliminar(Integer id) {
        artistaRepository.deleteById(id);
    }
}