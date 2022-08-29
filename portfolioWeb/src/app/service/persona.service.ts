import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { persona } from '../model/persona.model';



@Injectable({
  providedIn: 'root'
})


export class PersonaService {

  URL = 'http://localhost:8080/personas/';
  
  constructor(private http: HttpClient) { }

  public getPersona(): Observable<persona> {
    // return this.http.get<persona>(this.URL+ 'traer/perfil?id=1');
    return this.http.get<persona>(this.URL+ 'traer/perfil');
  }

  public detail(id: number): Observable<persona>{
    return this.http.get<persona>(this.URL + `detail/${id}`);
  }

  public update(id: number, persona: persona): Observable<any>{
    return this.http.put<any>(this.URL + `editar/${id}`, persona);
  }

}
