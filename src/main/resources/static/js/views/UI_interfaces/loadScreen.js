export default class loadScreen{

    style = {

    }
    config = {
        message : "Cargando",
    }

    constructor(parentContainer,config=null){
        this.parentContainer = parentContainer;

        if(config!==null){
            this.config = config;
        }
        this.#createLoader();
    }

    load(){
        this.parentContainerChildren = Array.from(this.parentContainer.children);
        this.parentContainer.replaceChildren(this.html);
    }

    finished(UIElement=null){
        this.parentContainer.replaceChildren();
        if(UIElement !== null){
            this.parentContainer.replaceChildren(UIElement);
        }
        else{
            this.parentContainerChildren.forEach(element => {
                this.parentContainer.append(element);
            });
            
        }
        
    }

    #createLoader(){
        this.html = document.createElement("div");
        this.html.innerHTML = this.config.message;
    }
}