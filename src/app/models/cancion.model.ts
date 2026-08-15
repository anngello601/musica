export interface Cancion {
  id: number;
  titulo: string;
  duracion: number;
  archivo: string;
  letra: string;
  reproducciones: number;
  albumTitulo: string;      // ✅ Plano
  artistaNombre: string;    // ✅ Plano
  generoNombre: string;     // ✅ Plano
}
