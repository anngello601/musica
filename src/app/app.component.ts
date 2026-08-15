import { Component } from '@angular/core';
import { CancionListComponent } from './components/cancion-List/cancion-List.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CancionListComponent], // 👈 Debe estar aquí
  templateUrl: './app.component.html',
})

export class AppComponent {
  title = 'musica-frontend';
}
