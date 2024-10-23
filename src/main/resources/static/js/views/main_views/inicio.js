import AbstractView from "./View.js"

export default class extends AbstractView{
    constructor(){
        super();
        this.setTittle("inicio");
    }

    // async getHTML(){
    //     return fetch("views/inicio/index.html")
    //     .then((response)=>response.text())
    //     .then((html)=>{return html})
    // }
}