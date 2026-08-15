// ============================================
// SERVICIO: CancionService
// ============================================

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cancion } from '../models/cancion.model';

@Injectable({
  providedIn: 'root'
})
export class CancionService {

  // 📌 URL BASE DEL BACKEND (Spring Boot)
  private apiUrl = 'http://localhost:8080/api/canciones';

  constructor(private http: HttpClient) {
    console.log('✅ Servicio CancionService inicializado'); // 👈 Agrega esto
  }

  // ============================================
  // 1. OBTENER TODAS LAS CANCIONES (GET)
  // ============================================
  obtenerCanciones(): Observable<Cancion[]> {
    return this.http.get<Cancion[]>(this.apiUrl);
  }

  // ============================================
  // 2. OBTENER UNA CANCIÓN POR ID (GET)
  // ============================================
  obtenerCancionPorId(id: number): Observable<Cancion> {
    return this.http.get<Cancion>(`${this.apiUrl}/${id}`);
  }

  // ============================================
  // 3. CREAR UNA NUEVA CANCIÓN (POST)
  // ============================================
  crearCancion(cancion: Partial<Cancion>): Observable<Cancion> {
    return this.http.post<Cancion>(this.apiUrl, cancion);
  }

  // ============================================
  // 4. ACTUALIZAR UNA CANCIÓN (PUT)
  // ============================================
  actualizarCancion(id: number, cancion: Cancion): Observable<Cancion> {
    return this.http.put<Cancion>(`${this.apiUrl}/${id}`, cancion);
  }

  // ============================================
  // 5. ELIMINAR UNA CANCIÓN (DELETE)
  // ============================================
  eliminarCancion(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  // ============================================
  // 6. BUSCAR CANCIONES POR TÍTULO (GET)
  // ============================================
  buscarPorTitulo(titulo: string): Observable<Cancion[]> {
    return this.http.get<Cancion[]>(`${this.apiUrl}/buscar?titulo=${titulo}`);
  }


}
