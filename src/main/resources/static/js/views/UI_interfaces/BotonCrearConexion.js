import { FormularioConexionED } from "./FormularioConexion.js";

export class BottonCrearConexion{
    

    constructor(contenedor){
        this.html = document.createElement("button");
        this.html.innerHTML = "Crear Nueva Conexión!!";

        this.html.addEventListener('click',this.click);

        this.parent = contenedor;
        this.child = null;
    }

    async click(){
        const lol = await FormularioConexionED.create(this,this);
        this.style.display = 'none';
        lol.render();
    }

    render(){
        const parent = document.getElementById(this.parent);	
        parent.appendChild(this.html);
    };
}