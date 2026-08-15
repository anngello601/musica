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
@Table(name = "artistas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String bio;

    private String imagen;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime creado;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @JsonIgnore
    private List<Album> albumes = new ArrayList<>();

    @ManyToMany(mappedBy = "artistasFavoritos")
    @Builder.Default
    @JsonIgnore
    private List<Usuario> seguidores = new ArrayList<>();
}