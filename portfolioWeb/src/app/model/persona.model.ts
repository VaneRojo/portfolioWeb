export class persona{
    id?: number;
    nombre: string;
    apellido: string;
    telefono: string;
    mail: string;  
    img_perfil: string;
    img_banner: string;
    edad: number;
    titulo: string;
    introduccion: string;

    constructor(nombre: string,apellido: string,telefono: string,mail: string,img_perfil: string,img_banner: string, edad: number,titulo: string, introduccion: string) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.mail = mail;
        this.img_perfil = img_perfil;
        this.img_banner = img_banner;
        this.edad = edad;
        this.titulo = titulo;
        this.introduccion = introduccion;
    }
}