import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Educacion } from 'src/app/model/educacion';
import { EducacionService } from 'src/app/service/educacion.service';
import { Validators } from '@angular/forms';
import { FormControl } from '@angular/forms';

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


  nombreInsti = new FormControl('', Validators.compose([
    Validators.required,
    Validators.pattern(/[0-9A-Za-záéíóúÁÉÍÓÚÑñ.+°\s]$/)
  ]));
  nivelEdu = new FormControl('', Validators.compose([
    Validators.required,
    Validators.pattern(/[A-Za-záéíóúÁÉÍÓÚÑñ.\s]$/)
  ]));
  titulo = new FormControl('', Validators.compose([
    Validators.required,
    Validators.pattern(/[A-Za-záéíóúÁÉÍÓÚÑñ.\s]$/)
  ]));
  

}
