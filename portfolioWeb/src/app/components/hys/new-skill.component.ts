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


    const skill = new Skill(this.nombreS, this.porcentajeS, this.urlImagenS, this.mostrarImagenS);
    this.skillS.save(skill).subscribe(
      data => { 
        alert('Skill añadido');
        this.router.navigate(['']);
      },err =>{
        console.log(skill);
        alert("Falló " + err.message);
      }
    )
  }

}
