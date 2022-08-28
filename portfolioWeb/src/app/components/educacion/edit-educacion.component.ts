import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Educacion } from 'src/app/model/educacion';
import { EducacionService } from 'src/app/service/educacion.service';

@Component({
  selector: 'app-editeducacion',
  templateUrl: './edit-educacion.component.html',
  styleUrls: ['./edit-educacion.component.css']
})
export class EditeducacionComponent implements OnInit {

  edu: Educacion = null!;

  constructor(private sEducacion: EducacionService, private activatedRouter: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sEducacion.detail(id).subscribe(
      data => {
        this.edu = data;
    // this.fechaInicioE = this.fechaInicioE.toJSON().slice(0, 10);
        // data.fechaInicioE.toString();
        // data.fechaInicioE.getDate();

      }, err => {
        alert("Error al modificar educación");
        this.router.navigate(['']);
      }
      )
    }
    
    onUpdate(): void {
      const id = this.activatedRouter.snapshot.params['id'];
      this.sEducacion.update(id, this.edu).subscribe(
        data => {
          this.router.navigate(['']);
          alert("La educación se editó con éxito");
      },err => {
        alert("Error al modificar educación");
        this.router.navigate(['']);
      }
    )
  }


}