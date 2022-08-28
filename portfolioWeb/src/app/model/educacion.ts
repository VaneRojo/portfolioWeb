export class Educacion {
    id?: number;
    nombreInsti: string;
    tituloEdu: string;
    fechaInicioEdu: Date;
    fechaFinEdu: Date | null;
    descripcionEdu: string;
    nivelEdu: string;
    logoEdu: string;

    constructor(nombreInsti: string, tituloEdu: string, fechaInicioEdu: Date, fechaFinEdu: Date | null, descripcionEdu: string, nivelEdu: string, logoEdu: string){
        this.nombreInsti = nombreInsti;
        this.tituloEdu = tituloEdu;
        this.fechaInicioEdu = fechaInicioEdu;
        this.fechaFinEdu = fechaFinEdu;
        this.descripcionEdu = descripcionEdu;
        this.nivelEdu = nivelEdu;
        this.logoEdu = logoEdu;
    } 
}
