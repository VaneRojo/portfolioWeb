export class Skill {
    id?: number;
    nombreP: string;
    porcentajeS: string;
    urlImagenS: string;
    mostrarImagenS: boolean;
    

    constructor(nombreP: string, porcentajeS: string, urlImagenS: string, mostrarImagenS: boolean){
        this.nombreP = nombreP;
        this.porcentajeS = porcentajeS;
        this.urlImagenS = urlImagenS;
        this.mostrarImagenS = mostrarImagenS;
       
    } 
}
