import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Educacion } from 'src/app/model/educacion';
import { EducacionService } from 'src/app/service/educacion.service';

@Component({
  selector: 'app-new-educacion',
  templateUrl: './new-educacion.component.html',
  styleUrls: ['./new-educacion.component.css']
})
export class NewEducacionComponent implements OnInit {
  nombreInsti: string = '';
  tituloEdu:string = '';
  fechaInicioEdu:  Date = new Date();
  fechaFinEdu:  Date | null = null;
  descripcionEdu: string = '';
  nivelEdu: string = '';
  logoEdu:string = '';

 
  constructor(private educacionS: EducacionService, private router: Router) { }

  ngOnInit(): void {
    
  }
  

  onCreate(): void {

    
    if(this.logoEdu == ""){
      this.logoEdu = "../../../assets/img/no-logo.png";
    }

    // this.fechaInicioE = new Date(this.fechaInicioE.toISOString());
    // this.fechaInicioE = this.fechaInicioE.toJSON().slice(0, 10);
    // this.fechaInicioE = this.fechaInicioE.toString();
    // this.fechaInicioE = new Date(this.fechaInicioE.valueOf());

    const expe = new Educacion(this.nombreInsti, this.tituloEdu, this.fechaInicioEdu, this.fechaFinEdu, this.descripcionEdu, this.nivelEdu, this.logoEdu);
    this.educacionS.save(expe).subscribe(
      data => { 
        alert('Experiencia añadida');
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
