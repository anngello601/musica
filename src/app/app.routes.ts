import { Routes } from '@angular/router';
import { CancionListComponent } from './components/cancion-List/cancion-List.component';

export const routes: Routes = [
  { path: '', component: CancionListComponent },
  { path: '**', redirectTo: '' }
];
