package com.example.musica.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = 50)
    private String usuario;

    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @Column(nullable = false)
    private String password;

    private String foto;

    @Builder.Default
    private Boolean premium = false;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime creado;

    @UpdateTimestamp
    private LocalDateTime actualizado;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Lista> listas = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "usuario_fav_canciones",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "cancion_id")
    )
    @Builder.Default
    private List<Cancion> cancionesFavoritas = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "usuario_fav_artistas",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "artista_id")
    )
    @Builder.Default
    private List<Artista> artistasFavoritos = new ArrayList<>();
}