import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { persona } from 'src/app/model/persona.model';
import { PersonaService } from 'src/app/service/persona.service';
import { Validators } from '@angular/forms';


@Component({
  selector: 'app-edit-acerca-de',
  templateUrl: './edit-acerca-de.component.html',
  styleUrls: ['./edit-acerca-de.component.css']
})
export class EditAcercaDeComponent implements OnInit {

  nombre = new FormControl('', Validators.compose([
    Validators.required,
    Validators.pattern(/[A-Za-záéíóúÁÉÍÓÚÑñ.\s]$/)
  ]));
  apellido = new FormControl('', Validators.compose([
    Validators.required,
    Validators.pattern(/[A-Za-záéíóúÁÉÍÓÚÑñ.\s]$/)
  ]));
  titulo = new FormControl('', Validators.compose([
    Validators.required,
    Validators.pattern(/[A-Za-záéíóúÁÉÍÓÚÑñ.\s]$/)
  ]));
  telefono = new FormControl('', Validators.compose([
    Validators.required,
    Validators.pattern(/^[0-9+-]{8,13}$/)
  ]));
  
  email = new FormControl('', Validators.compose([
    Validators.required,
    Validators.pattern(/^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9]+\.[a-zA-Z\.]+$/)
  ]));
  

  per: persona = new persona("","","","","","",0,"","");

  constructor(private sPersona: PersonaService, private activatedRouter: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sPersona.detail(id).subscribe(
      data => {
        this.per = data;
      }, err => {
        alert("Error al modificar información");
        this.router.navigate(['']);
      }
    )
  }

  onUpdate(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    console.log(this.per);
    this.sPersona.update(id, this.per).subscribe(
        data => {
          this.router.navigate(['']);
          alert("La información se editó con éxito");

      },err => {
        console.log("Error: " + err);
        alert("Error al modificar información");
      }
    )
  }

}


