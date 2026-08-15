import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CancionService } from '../../services/cancion.service';
import { Cancion } from '../../models/cancion.model';

@Component({
  selector: 'app-cancion-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './cancion-List.component.html',
  styleUrls: ['./cancion-List.component.css']
})
export class CancionListComponent implements OnInit {
  canciones: Cancion[] = [];
  loading: boolean = true;
  errorMessage: string = '';

  // 📌 Inyectamos el ChangeDetectorRef
  constructor(
    private cancionService: CancionService,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.cargarCanciones();
  }

  // 📌 Método para cargar canciones con ChangeDetectorRef
  cargarCanciones(): void {
    this.loading = true;
    this.errorMessage = '';

    this.cancionService.obtenerCanciones().subscribe({
      next: (data) => {
        this.canciones = data;
        this.loading = false;
        // 🔥 Forzamos la detección de cambios
        this.cdr.detectChanges();
        console.log('✅ Datos recibidos y vista actualizada');
      },
      error: (err) => {
        console.error('❌ Error al cargar canciones:', err);
        this.errorMessage = 'Error al cargar las canciones. Verifica el backend.';
        this.loading = false;
        // 🔥 También forzamos la detección en caso de error
        this.cdr.detectChanges();
      }
    });
  }

  // 📌 Método para eliminar canciones
  eliminarCancion(id: number): void {
    if (confirm('¿Estás seguro de eliminar esta canción?')) {
      this.cancionService.eliminarCancion(id).subscribe({
        next: () => {
          this.canciones = this.canciones.filter(c => c.id !== id);
          this.cdr.detectChanges();
          console.log('✅ Canción eliminada');
        },
        error: (err) => {
          console.error('❌ Error al eliminar:', err);
          alert('Error al eliminar la canción.');
        }
      });
    }
  }
}
