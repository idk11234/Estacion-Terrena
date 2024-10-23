import AbstractView from "./View.js"

export default class extends AbstractView{
    constructor(){
        super();
        this.setTittle("preferencias");
    }

    // async getHTML(){
    //     return fetch("views/preferencias/index.html")
    //     .then((response)=>response.text())
    //     .then((html)=>{return html})
    // }
}