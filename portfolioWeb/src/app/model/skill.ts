export class Skill {
    id?: number;
    nombreS: string;
    porcentajeS: number;
    urlImagenS: string;
    mostrarImagenS: boolean;
    

    constructor(nombreS: string, porcentajeS: number, urlImagenS: string, mostrarImagenS: boolean){
        this.nombreS = nombreS;
        this.porcentajeS = porcentajeS;
        this.urlImagenS = urlImagenS;
        this.mostrarImagenS = mostrarImagenS;
       
    } 
}
