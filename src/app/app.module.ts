// app.component.ts
import { Component } from '@angular/core';
import { CancionListComponent } from './components/cancion-List/cancion-List.component';

@Component({
  selector: 'app-root',
  standalone: true,  // 👈 Si es standalone
  imports: [CancionListComponent],  // 👈 Importa el componente aquí
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent { }
