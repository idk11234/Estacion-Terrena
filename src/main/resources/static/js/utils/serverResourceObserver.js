import serverResourceHandler from "./serverResourceHandler.js";

export default class {

    static observer = new MutationObserver(mutations =>{
        mutations.forEach(function(mutation){
            const addedElementsToObserve = searchObservableElements(mutation.addedNodes);
            const removedElementsToObserve = searchObservableElements(mutation.removedNodes);
   
            addedElementsToObserve.forEach(element=>{
                serverResourceHandler.inUse(element);
            })
            
            removedElementsToObserve.forEach(element=>{
                serverResourceHandler.unUse(element);
            })
            
        })
    }).observe(document.getElementById('app'),{childList:true,subtree:true});   
}

function searchObservableElements(nodeList){
    let elementsToObserve = new Array();
    search(nodeList,elementsToObserve);
    return elementsToObserve;
}

function  search(nodeList,elementsToObserve){
    nodeList.forEach(node=>{
        if(node.nodeType == 1){
            if(node.hasChildNodes()){
                
                if((typeof node.attributes !== typeof undefined)){
                    const uiResource = node.attributes.getNamedItem("data-uiresource");
                    if(uiResource !== null){
                        elementsToObserve.push(node);
                    }
                }
                search(node.childNodes,elementsToObserve);

            }else{

                if((typeof node.attributes !== typeof undefined)){
                    const uiResource = node.attributes.getNamedItem("data-uiresource");
                    if(uiResource !== null){

                        elementsToObserve.push(node);

                    }
                }

            }
        }
    })
}