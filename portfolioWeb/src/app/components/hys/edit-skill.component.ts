import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Skill } from 'src/app/model/skill';
import { SkillService } from 'src/app/service/skill.service';

@Component({
  selector: 'app-edit-skill',
  templateUrl: './edit-skill.component.html',
  styleUrls: ['./edit-skill.component.css']
})
export class EditSkillComponent implements OnInit {
  skill: Skill = null!;

  constructor(private sSkill: SkillService, private activatedRouter: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sSkill.detail(id).subscribe(
      data => {
        this.skill = data;
        // this.fechaInicioE = this.fechaInicioE.toJSON().slice(0, 10);
        // data.fechaInicioE.toString();
        // data.fechaInicioE.getDate();

      }, err => {
        alert("Error al modificar experiencia");
        this.router.navigate(['']);
      }
      )
    }
    
    onUpdate(): void {
      const id = this.activatedRouter.snapshot.params['id'];
      this.sSkill.update(id, this.skill).subscribe(
        data => {
          this.router.navigate(['']);
          alert("La experiencia se editó con éxito");
      },err => {
        alert("Error al modificar experiencia");
        // this.router.navigate(['']);
      }
    )
  }


}
