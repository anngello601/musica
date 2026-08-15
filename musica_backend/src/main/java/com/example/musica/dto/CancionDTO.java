package com.example.musica.dto;

// No uses @Data de Lombok en DTOs si quieres máxima compatibilidad
// Pero podemos usarlo para simplificar
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CancionDTO {
    private Integer id;
    private String titulo;
    private Integer duracion;
    private String archivo;
    private String letra;
    private Integer reproducciones;
    private String albumTitulo;
    private String artistaNombre;
    private String generoNombre;
}