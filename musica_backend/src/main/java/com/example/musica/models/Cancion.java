package com.example.musica.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "canciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cancion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String titulo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")
    @JsonIgnore
    private Album album;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genero_id")
    @JsonIgnore
    private Genero genero;

    @Column(nullable = false)
    private Integer duracion; // segundos

    @Column(nullable = false)
    private String archivo;

    @Column(columnDefinition = "TEXT")
    private String letra;

    @Builder.Default
    private Integer reproducciones = 0;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime creado;

    @ManyToMany(mappedBy = "canciones")
    @Builder.Default
    @JsonIgnore
    private List<Lista> listas = new ArrayList<>();

    @ManyToMany(mappedBy = "cancionesFavoritas")
    @JsonIgnore
    @Builder.Default
    private List<Usuario> usuariosFavoritos = new ArrayList<>();
}