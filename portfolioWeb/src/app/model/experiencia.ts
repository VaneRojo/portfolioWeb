export class Experiencia {
    id? : number;
    nombreE : string;
    descripcionE : string;
    logoE : string;

    constructor(nombreE: string, descripcionE: string, logoE: string){
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.logoE = logoE;
    }
}
