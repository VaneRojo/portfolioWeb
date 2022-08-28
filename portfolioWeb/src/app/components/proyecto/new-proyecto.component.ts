import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Proyecto } from 'src/app/model/proyecto';
import { ProyectoService } from 'src/app/service/proyecto.service';

@Component({
  selector: 'app-new-proyecto',
  templateUrl: './new-proyecto.component.html',
  styleUrls: ['./new-proyecto.component.css']
})
export class NewProyectoComponent implements OnInit {

  nombreP: string;
  descripcionP: string;
  urlP: string;
  yearP: string;
  logoP: string;

  constructor(private proyectoS: ProyectoService, private router:Router) { }

  ngOnInit(): void {
  }

  onCreate(): void {

    
    if(this.logoP == null){
      this.logoP = "../../../assets/img/no-logo.png";
    }

    // this.fechaInicioE = new Date(this.fechaInicioE.toISOString());
    // this.fechaInicioE = this.fechaInicioE.toJSON().slice(0, 10);
    // this.fechaInicioE = this.fechaInicioE.toString();
    // this.fechaInicioE = new Date(this.fechaInicioE.valueOf());

    const expe = new Proyecto(this.nombreP, this.descripcionP, this.urlP, this.yearP, this.logoP);
    this.proyectoS.save(expe).subscribe(
      data => { 
        alert('Proyecto añadido');
        // console.log(data);
        this.router.navigate(['']);
      },err =>{
        console.log(expe);
        alert("Falló " + err.message);
        // this.router.navigate(['']);
      }
    )
  }

}
