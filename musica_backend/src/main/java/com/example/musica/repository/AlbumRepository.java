package com.example.musica.repository;

import com.example.musica.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
}