import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NuevoUsuario } from '../model/nuevo-usuario';
import { LoginUsuario } from '../model/login-usuario';
import { JwtDto } from '../model/jwt-dto';
import { persona } from '../model/persona.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  authURL = 'https://back-end-pw.herokuapp.com/auth/';

  constructor(private httpClient: HttpClient) { }

  public nuevo(nuevoUsuario:NuevoUsuario):Observable<any> {
    return this.httpClient.post<any>(this.authURL + 'nuevo', nuevoUsuario);
  }

  public login(loginUsuario: LoginUsuario): Observable<JwtDto> {
    return this.httpClient.post<JwtDto>(this.authURL + 'login', loginUsuario);
  }

  public editar(id: number, persona: persona): Observable<any> {
    return this.httpClient.post<JwtDto>(this.authURL + `editar/${id}`, persona);
  }
}
