package com.example.musica.service;

import com.example.musica.dto.CancionDTO;
import com.example.musica.models.Cancion;
import com.example.musica.repository.CancionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CancionService {


    private final CancionRepository cancionRepository;

    public CancionService(CancionRepository cancionRepository) {
        this.cancionRepository = cancionRepository;
    }

    public List<CancionDTO> obtenerTodasDTO() {
        List<Cancion> canciones = cancionRepository.findAll();
        return canciones.stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    private CancionDTO convertirADTO(Cancion cancion) {
        String albumTitulo = (cancion.getAlbum() != null) ? cancion.getAlbum().getTitulo() : null;
        String artistaNombre = (cancion.getAlbum() != null && cancion.getAlbum().getArtista() != null) 
                ? cancion.getAlbum().getArtista().getNombre() : null;
        String generoNombre = (cancion.getGenero() != null) 
                ? cancion.getGenero().getNombre() : null;

        return new CancionDTO(
                cancion.getId(),
                cancion.getTitulo(),
                cancion.getDuracion(),
                cancion.getArchivo(),
                cancion.getLetra(),
                cancion.getReproducciones(),
                albumTitulo,
                artistaNombre,
                generoNombre
        );
    }
}