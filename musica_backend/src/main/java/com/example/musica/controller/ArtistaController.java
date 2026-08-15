package com.example.musica.controller;

import com.example.musica.models.Artista;
import com.example.musica.service.ArtistaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artistas")
@CrossOrigin(origins = "http://localhost:4200")
public class ArtistaController {

    private final ArtistaService artistaService;

    
    public ArtistaController(ArtistaService artistaService) {
        this.artistaService = artistaService;
    }

    @GetMapping
    public List<Artista> obtenerTodos() {
        return artistaService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artista> obtenerPorId(@PathVariable Integer id) {
        return artistaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Artista crear(@RequestBody Artista artista) {
        return artistaService.guardar(artista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artista> actualizar(@PathVariable Integer id, @RequestBody Artista artista) {
        return artistaService.obtenerPorId(id)
                .map(artistaExistente -> {
                    artista.setId(id);
                    return ResponseEntity.ok(artistaService.guardar(artista));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (artistaService.obtenerPorId(id).isPresent()) {
            artistaService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}