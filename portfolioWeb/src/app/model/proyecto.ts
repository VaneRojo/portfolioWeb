export class Proyecto {
    id?: number;
    nombreP: string;
    descripcionP: string;
    urlP: string;
    yearP: string;
    logoP: string;

    constructor(nombreP: string, descripcionP: string, urlP: string, yearP: string, logoP: string){
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.urlP = urlP;
        this.yearP = yearP;
        this.logoP = logoP;
    } 
}
