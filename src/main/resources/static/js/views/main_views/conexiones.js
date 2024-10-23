import { BottonCrearConexion } from "../UI_interfaces/BotonCrearConexion.js";
import View from "./View.js"

export default class ConexionesView extends View{

    constructor(){
        // super();
        // this.setTittle("conexiones");
        const UIObjects = [
            new BottonCrearConexion("creador-conexiones"),
        ];

    
        View.create("Conexiones",UIObjects);
        
    }

   

    




}