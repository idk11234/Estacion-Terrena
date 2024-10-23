export class UARTConfigForm {

    constructor(parent){
        this.SerialPorts = null;
        this.SerialPortsSelect = null;
        this.parent = parent;

    }
    static async create(parent){
        const ret = new UARTConfigForm(parent);
        return ret.initialize();
    }

    async initialize(){
        const htmlDoc = await this.getHTML();
        const wraper = document.createElement("fieldset");
        const label = document.createElement("legend");
        label.innerText="Configuración";
        wraper.appendChild(label)

        this.html = wraper.appendChild(htmlDoc.getElementsByTagName("body")[0].children[0]);
        
        this.SerialPortsSelect = htmlDoc.getElementsByName("PORT")[0];
        this.AdvancedConfigButton = this.html.getElementsByClassName("advanced-config-button")[0];

        this.AdvancedConfigButton.addEventListener("click",(event)=>{
            event.preventDefault();
            const config = this.html.getElementsByClassName("advanced-config")[0];
            
            if(config.style.display === 'block'){
                config.style.display = 'none';
            }
            else{
                config.style.display = 'block';
            }
        })

        this.render();

        return this;
    }

    async getHTML(){
        let html = await fetch(`views/conexionesView/ED_Protocols/UART.html`)
        .then((response)=>response.text())
        .then((html)=>{return html});

        const parser = new DOMParser;
        html = parser.parseFromString(html,"text/html");
        return html;
    }

    render(){	
        this.parent.replaceChildren(this.html);
    }
}