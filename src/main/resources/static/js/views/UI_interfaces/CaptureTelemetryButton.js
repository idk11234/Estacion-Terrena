export default class CaptureTelemetryButton{

    constructor(){
        this.html = document.createElement("button");
        this.html.innerText = "Iniciar Monitoreo!!";
        this.html.setAttribute("class","launch-button");

        this.html.addEventListener("click",this.launch)
    }

    render(){

    }

    async launch(event){
        const response = await fetch(App.URL+"/conexiones/launch",{
            method:"GET",
            body: JSON.stringify(data),
            headers: new Headers({'content-type': 'application/json'})
        }).then((response)=>console.log(response));


    }
}