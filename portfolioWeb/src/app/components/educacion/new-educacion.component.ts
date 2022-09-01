import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Educacion } from 'src/app/model/educacion';
import { EducacionService } from 'src/app/service/educacion.service';
import { FormControl, Validators } from '@angular/forms';

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
      this.logoEdu = "../../../assets/img/estudio.png";
    }


    const expe = new Educacion(this.nombreInsti, this.tituloEdu, this.fechaInicioEdu, this.fechaFinEdu, this.descripcionEdu, this.nivelEdu, this.logoEdu);
    this.educacionS.save(expe).subscribe(
      data => { 
        alert('Educación añadida');
        
        this.router.navigate(['']);
      },err =>{
        console.log(expe);
        alert("Falló " + err.message);
        
      }
    )
  }


  nombre = new FormControl('', Validators.compose([
    Validators.required,
    Validators.pattern(/[0-9A-Za-záéíóúÁÉÍÓÚÑñ.+°\s]$/)
  ]));
  nivel = new FormControl('', Validators.compose([
    Validators.required,
    Validators.pattern(/[A-Za-záéíóúÁÉÍÓÚÑñ.\s]$/)
  ]));
  titulo = new FormControl('', Validators.compose([
    Validators.required,
    Validators.pattern(/[A-Za-záéíóúÁÉÍÓÚÑñ.\s]$/)
  ]));

}
