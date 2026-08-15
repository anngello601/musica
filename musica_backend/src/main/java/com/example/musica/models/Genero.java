package com.example.musica.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "generos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = 50)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @OneToMany(mappedBy = "genero")
    @Builder.Default
    private List<Cancion> canciones = new ArrayList<>();
}