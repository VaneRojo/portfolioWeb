export class Experiencia {
    id? : number;
    nombreE : string;
    descripcionE : string;
    logoE : string;
    fechaInicioE?: Date;
    fechaFinE?: Date;
    trabajoActualE: boolean = false;

    constructor(nombreE: string, descripcionE: string, logoE: string,  trabajoActualE: boolean, fechaInicioE: Date, fechaFinE?: Date) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.logoE = logoE;
        this.fechaInicioE = fechaInicioE;   
        this.fechaFinE = fechaFinE;
        this.trabajoActualE = trabajoActualE;
    }
}
