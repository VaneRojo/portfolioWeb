import { Component, OnInit } from '@angular/core';
import { Proyecto } from 'src/app/model/proyecto';
import { ProyectoService } from 'src/app/service/proyecto.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-proyecto',
  templateUrl: './proyecto.component.html',
  styleUrls: ['./proyecto.component.css']
})
export class ProyectoComponent implements OnInit {
  proyecto: Proyecto[] = [];

  constructor(private proyectoS: ProyectoService, private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarEducacion();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else{
      this.isLogged = false;

    }
  }

  cargarEducacion(): void {
    this.proyectoS.lista().subscribe(
      data => {
        this.proyecto = data;
      }
    )
  }

  delete(id?: number){
    if(id != undefined){
      this.proyectoS.delete(id).subscribe(
        data => {
          this.cargarEducacion();
          alert("El proyecto se eliminó con éxito");
        }, err => {
          alert("No se pudo borrar el proyecto");
        }
      )
    }
  }

}
