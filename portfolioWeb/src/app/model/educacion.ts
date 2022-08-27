export class Educacion {
    id: number;
    nombreInsti: string;
    tituloEdu: string;
    fechaInicioEdu: Date;
    fechaFinEdu: Date;
    descripcionEdu: string;
    nivelEdu: string;

    constructor(nombreInsti: string, tituloEdu: string, fechaInicioEdu: Date, fechaFinEdu: Date, descripcionEdu: string, nivelEdu: string){
        this.nombreInsti = nombreInsti;
        this.tituloEdu = tituloEdu;
        this.fechaInicioEdu = fechaInicioEdu;
        this.fechaInicioEdu = fechaFinEdu;
        this.descripcionEdu = descripcionEdu;
        this.nivelEdu = nivelEdu;
    } 
}
