export default class View{

    constructor(view,uiObjects,layout){
        this.view = view.toLowerCase();
        this.setTittle(view);
        this.layout = layout;
        this.uiObjects = uiObjects;
    }

    setTittle(tittle){
        document.tittle = tittle;
    }

    async initialize(){
        this.html = await this.getHTML();
        this.renderView();
        this.renderElements();
        return this;
    }

    static async create(view,uiObjects,layout){
        let ret = new View(view,uiObjects,layout);
        return ret.initialize();
    }

    async getHTML(){
        return fetch(`views/${this.view}View/index.html`)
        .then((response)=>response.text())
        .then((html)=>{const parser = new DOMParser;
            html = parser.parseFromString(html,"text/html");
            return html.getElementsByTagName("body")[0].children[0];
        })

        
        
    }


    async renderView(){
        console.log("AAAAAAAA")
        console.log(this.html)
        document.querySelector("#app").replaceChildren(this.html);
    }

    async renderElements(){
        this.uiObjects.forEach((uiObject)=>{
            uiObject.render();
        }
    )

    }
}