import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditeducacionComponent } from './components/educacion/edit-educacion.component';

import { NewEducacionComponent } from './components/Educacion/new-educacion.component';
import { EditExperienciaComponent } from './components/experiencia/edit-experiencia.component';
import { NewExperienciaComponent } from './components/experiencia/new-experiencia.component';
import { HomeComponent } from './components/home/home.component';
import { EditSkillComponent } from './components/hys/edit-skill.component';
import { NewSkillComponent } from './components/hys/new-skill.component';
import { LoginComponent } from './components/login/login.component';
import { EditProyectoComponent } from './components/proyecto/edit-proyecto.component';
import { NewProyectoComponent } from './components/proyecto/new-proyecto.component';

const routes: Routes = [
  {path:'', component: HomeComponent},
  {path:'login', component: LoginComponent},
  {path:'nuevaExp', component: NewExperienciaComponent},
  {path:'editExp/:id', component: EditExperienciaComponent},
  {path:'nuevaEdu', component: NewEducacionComponent},
  {path:'editEdu/:id', component: EditeducacionComponent},
  {path:'nuevoP', component: NewProyectoComponent},
  {path:'editP/:id', component: EditProyectoComponent},
  {path:'nuevaS', component: NewSkillComponent},
  {path:'editS/:id', component: EditSkillComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
