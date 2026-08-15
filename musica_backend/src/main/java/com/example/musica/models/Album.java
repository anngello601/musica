package com.example.musica.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "albumes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String titulo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artista_id", nullable = false)
    private Artista artista;

    private String portada;

    private LocalDate lanzamiento;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime creado;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
     @JsonIgnore
    private List<Cancion> canciones = new ArrayList<>();
}