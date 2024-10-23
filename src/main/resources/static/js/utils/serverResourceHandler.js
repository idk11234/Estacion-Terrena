export default class serverResourceHandler{

    static #resources = {};

    static inUse(node){
        const uiResource = node.attributes.getNamedItem("data-uiresource").value;
        if(this.#resources.hasOwnProperty(uiResource)){
            console.log(this.#resources[uiResource]);
            this.#resources[uiResource].push(node);
            console.log("ADDED!!!");
            console.log(this.#resources[uiResource]);
        }
        else{
            const resources = this.#resources;
            window.stompClient.subscribe(`/app/ui/${uiResource}`,function(message){
                const body = JSON.parse(message.body);
                const data = body.data;
                const uiResource = body.name;

                const users = resources[uiResource];

                users.forEach(DOMnode => {
                    render(uiResource,DOMnode,data);
                });
            });
            resources[uiResource] = [node];
            listen(uiResource);
            console.log("SUBSCRIBED!!!");
        }
    }

    static unUse(node){
        const uiResource = node.attributes.getNamedItem("data-uiresource").value;
        const elementInUse = this.#resources[uiResource];
        let index = null;
        elementInUse.forEach((element,i)=>{
            if(node.isSameNode(element)){
                //this.#resources[uiResource].splice(i,1);
                index =i;
            }
        })
        this.#resources[uiResource].splice(index,1);
        
        if(this.#resources[uiResource].length===0){
            delete this.#resources[uiResource];
            unlisten(uiResource);
            console.log("UNSUBSCRIBED!!!");
        }
    }


    
}

function listen(uiResource){
    window.stompClient.send("/hoi/ui",{},`{
        "resource": "${uiResource}",
        "use":true
    }`)
}

function unlisten(uiResource){
    window.stompClient.send("/hoi/ui",{},`{
        "resource":"${uiResource}",
        "use":false
    }`)
}



function render(uiResource,node,data){

    switch (uiResource) {        
        case "COMPorts":
            renderCOMPorts(node,data);
            break;

        case "connections":
            renderCurrentConnections(node,data);
            break;
    
        default:
            console.log("ERROR: NO EXISTE EL RECURSO UI!!");
            break;
    }
}


function renderCOMPorts(node,data){
    const key = node.tagName.toLowerCase();
    switch (key) {
        
        case "select":
            let options = ""
            if(data.length !== 0){
                data.forEach(element=>{
                    options += `<option value="${element}">${element}</option>`;
                })
                node.innerHTML = options;
            }
            break;
    
        default:
            let text = ""
            data.forEach(element=>{
                text += `${element}`;
            })
            node.innerHTML = text;
            break;
    }
}


function renderCurrentConnections(node,data){

}