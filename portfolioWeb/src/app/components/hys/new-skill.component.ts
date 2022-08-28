import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Skill } from 'src/app/model/skill';
import { SkillService } from 'src/app/service/skill.service';

@Component({
  selector: 'app-new-skill',
  templateUrl: './new-skill.component.html',
  styleUrls: ['./new-skill.component.css']
})
export class NewSkillComponent implements OnInit {

  nombreS: string;
  porcentajeS: number;
  urlImagenS: string;
  mostrarImagenS: boolean;

  constructor(private skillS: SkillService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void {

    
    // if(this.logoEdu == ""){
    //   this.logoEdu = "../../../assets/img/no-logo.png";
    // }

    // this.fechaInicioE = new Date(this.fechaInicioE.toISOString());
    // this.fechaInicioE = this.fechaInicioE.toJSON().slice(0, 10);
    // this.fechaInicioE = this.fechaInicioE.toString();
    // this.fechaInicioE = new Date(this.fechaInicioE.valueOf());

    const skill = new Skill(this.nombreS, this.porcentajeS, this.urlImagenS, this.mostrarImagenS);
    this.skillS.save(skill).subscribe(
      data => { 
        alert('Skill añadido');
        // console.log(data);
        this.router.navigate(['']);
      },err =>{
        console.log(skill);
        alert("Falló " + err.message);
        // this.router.navigate(['']);
      }
    )
  }

}
