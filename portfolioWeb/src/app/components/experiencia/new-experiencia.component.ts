import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Experiencia } from 'src/app/model/experiencia';
import { SExperienciaService } from 'src/app/service/s-experiencia.service';

@Component({
  selector: 'app-new-experiencia',
  templateUrl: './new-experiencia.component.html',
  styleUrls: ['./new-experiencia.component.css'],
  providers: [DatePipe]
})
export class NewExperienciaComponent implements OnInit {

  nombreE: string = '';
  descripcionE:string = '';
  logoE:string = '';
  trabajoActualE: boolean = false;
  fechaInicioE:  Date = new Date();
  fechaFinE:  Date | null = null;

  private trabajoActual = 'Actualidad';
  // private datePipe: DatePipe;


  constructor(private sExperiencia: SExperienciaService, private router: Router) { }

  ngOnInit(): void {
    
  }
  
  getTrabajoActual(): string {
    return this.trabajoActual;
  }

  onCreate(): void {

    if (this.trabajoActualE == true) {
      // this.fechaFinE = new Date();
      this.fechaFinE = null;
    }

    if(this.logoE == ""){
      this.logoE = "../../../assets/img/no-logo.png";
    }

    // this.fechaInicioE = new Date(this.fechaInicioE.toISOString());
    // this.fechaInicioE = this.fechaInicioE.toJSON().slice(0, 10);
    // this.fechaInicioE = this.fechaInicioE.toString();
    // this.fechaInicioE = new Date(this.fechaInicioE.valueOf());

    const expe = new Experiencia(this.nombreE, this.descripcionE, this.logoE, this.trabajoActualE, this.fechaInicioE, this.fechaFinE);
    this.sExperiencia.save(expe).subscribe(
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
