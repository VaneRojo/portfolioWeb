import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { persona } from 'src/app/model/persona.model';
import { PersonaService } from 'src/app/service/persona.service';

@Component({
  selector: 'app-edit-acerca-de',
  templateUrl: './edit-acerca-de.component.html',
  styleUrls: ['./edit-acerca-de.component.css']
})
export class EditAcercaDeComponent implements OnInit {

  per: persona = new persona("","","","","","",0,"","");

  constructor(private sPersona: PersonaService, private activatedRouter: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sPersona.detail(id).subscribe(
      data => {
        this.per = data;
        // this.fechaInicioE = this.fechaInicioE.toJSON().slice(0, 10);
        // data.fechaInicioE.toString();
        // data.fechaInicioE.getDate();

      }, err => {
        alert("nginitError al modificar información");
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
        console.log("Error: " + data);
        alert("Error al modificar información");
      }
    )
  }

}
