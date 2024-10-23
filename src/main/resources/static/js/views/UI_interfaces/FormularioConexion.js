import App from "../../App.js";
import conexion from "../../conexiones/conexion.js";
import serverResourceObserver from "../../utils/serverResourceObserver.js";
import { UARTConfigForm } from "./EDProtocolsForms/UARTConfigForm.js";
import loadScreen from "./loadScreen.js";

export class FormularioConexionED{
    
    constructor(contenedor,creator = null){
        this.parent = contenedor;
        this.child = null;
        this.cancelButton = null;
        this.connectButton = null;
        this.creator = creator;
        this.self = this;
    }

    static async create(contenedor){
        let ret = new FormularioConexionED(contenedor.parentElement,contenedor);
        return ret.initialize();
    }

    async initialize(){
        const parser = new DOMParser;
        this.html = await this.getHTML();
        this.html = parser.parseFromString(this.html,"text/html");

        this.cancelButton = this.html.getElementById("cancelar_conexion_ED");
        this.connectButton = this.html.getElementById("crear_conexion_ED");
        this.specificConfig =   this.html.getElementById("config_especifica_ED");

        this.html = this.html.getElementsByTagName("form")[0];

        this.cancelButton.addEventListener("click",(event)=>{
            event.preventDefault();
            this.seppuku();
        })
        this.connectButton.addEventListener("click",event=>{
            event.preventDefault();
            this.connect();
        })
        this.html.addEventListener("change",event=>{this.change(event,this)});
    
        return this;
    
    }

    async getHTML(){
        return fetch(`views/conexionesView/ConexionForm.html`)
        .then((response)=>response.text())
        .then((html)=>{

            return html
        })
    }

    render(){
        //potential helper function insertUniqueElement
        const childs = this.parent.childNodes;
        let existsInParent = false;
        let oldNode = null;
    
        childs.forEach((node)=>{
            if (node.id === this.html.id){
                existsInParent = true;
                oldNode = node
                return;
            }
            
        })
        if(existsInParent){
            this.parent.replaceChild(this.html,oldNode);
            console.log("replaced!")
        }
        else{
            this.parent.appendChild(this.html);
            console.log("appended!!")
        }
    };

    seppuku(){
        if(this.creator !== null){
            this.creator.style = window.getComputedStyle(this.creator)
        }
        this.parent.removeChild(this.html);
    }

    async connect(){
        this.cancelButton.setAttribute("disabled","");
        this.connectButton.setAttribute("disabled","");
        var formData = new FormData(this.html);
        const form = Object.fromEntries(formData);
        const protocol = form.protocol
        delete form.protocol

        const lol= {
            connected: 0,
            protocol: protocol,
            config: form 
        }
        const data = new conexion("lol",lol);

       const loading = new loadScreen(this.specificConfig);
       loading.load();

        const response = await fetch(App.URL+"/conexiones",{
            method:"POST",
            body: JSON.stringify(data),
            headers: new Headers({'content-type': 'application/json'})
        }).then((response)=>response.text())
        .then((html)=>{
            loading.finished();
            return html
        });
        
        this.cancelButton.removeAttribute("disabled");
        this.connectButton.removeAttribute("disabled");
       
    }


    async change(event,that){
        const target =  event.target;
    
        switch(target.id){

            case "select_protocol_ED":
                switch (target.value) {
                    case "UART":
                        UARTConfigForm.create(that.specificConfig);
                        break;
                
                    default:
                        break;
                }
                    
                break;
            
             default:
            
                break;
        }     
    }
    
    send(){

    }
}