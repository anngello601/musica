package com.example.musica.controller;

import com.example.musica.dto.CancionDTO;
import com.example.musica.service.CancionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/canciones")
@CrossOrigin(origins = "http://localhost:4200")
public class CancionController {

    private final CancionService cancionService;
    public CancionController(CancionService cancionService) {
        this.cancionService = cancionService;
    }


    @GetMapping
    public List<CancionDTO> obtenerTodas() {
        return cancionService.obtenerTodasDTO();
    }
}