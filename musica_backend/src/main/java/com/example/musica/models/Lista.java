package com.example.musica.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "listas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Builder.Default
    private Boolean publica = true;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime creado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToMany
    @JoinTable(
            name = "lista_canciones",
            joinColumns = @JoinColumn(name = "lista_id"),
            inverseJoinColumns = @JoinColumn(name = "cancion_id")
    )
    @Builder.Default
    private List<Cancion> canciones = new ArrayList<>();
}