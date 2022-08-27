import { Component, OnInit } from '@angular/core';
import { subscribeOn } from 'rxjs';
import { Experiencia } from 'src/app/model/experiencia';

import { TokenService } from 'src/app/service/token.service';
import { DatePipe } from '@angular/common';
import { SExperienciaService } from 'src/app/service/s-experiencia.service';

@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css']
})
export class ExperienciaComponent implements OnInit {

  expe: Experiencia[] = [];

  constructor(private sExperiencia: SExperienciaService, private tokenService: TokenService) { }


  isLogged = false;

  ngOnInit(): void {

    this.cargarExperiencia();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else{
      this.isLogged = false;

    }

  }


  cargarExperiencia():void{
    
    this.sExperiencia.lista().subscribe(data => {this.expe = data});
  }


  delete(id?: number){
    if(id!= undefined){
      this.sExperiencia.delete(id).subscribe(
        data => {
          this.cargarExperiencia();
          alert("La experiencia se eliminó con éxito");
        }, err => {
          alert("No se pudo borrar la experiencia");
        }
      )
    }
  }


}
