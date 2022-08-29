export class persona{
    id?: number;
    nombre: String;
    apellido: String;
    telefono: String;
    mail: String;  
    img_perfil: String;
    img_banner: String;
    edad: number;
    titulo: String;
    introduccion: String;

    constructor(nombre: String,apellido: String,telefono: String,mail: String,img_perfil: String,img_banner: String, edad: number,titulo: String, introduccion: String) {
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