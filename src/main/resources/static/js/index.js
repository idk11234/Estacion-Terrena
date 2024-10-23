import serverResourceObserver from "./utils/serverResourceObserver.js";
import ConexionesView from "./views/main_views/conexiones.js";
import VisualizadorView from "./views/main_views/visualizador.js";
import View from "./views/main_views/View.js";
import clock from "./views/UI_interfaces/clock.js";
import App from "./App.js";
//import { Stomp } from "./libs/stomp.js";


 new App();

const navigateTo = url => {
    history.pushState(null,null,url);
    router();
}

const router = async() => {
    const routes = [
        {path: "/", view: "inicio"},
        {path: "/preferencias", view: "preferencias"},
        {path: "/conexiones", view: ConexionesView},
        {path: "/visualizador", view: VisualizadorView},
    ];

    let match = routes.find(route=> route.path === location.pathname);

    if (!match){
        match = routes[0];
    }

    const view =  new match.view;
   
};


window.addEventListener("popstate",router);

document.addEventListener("DOMContentLoaded",()=>{
    clock.showTime();

    setInterval(
        clock.showTime,
        1000
      )
    const navbar = document.getElementById("mainNavigation"); 
    navbar.childNodes.forEach(child=>{
        child.addEventListener("click", e => {
        e.preventDefault();
        navigateTo(e.currentTarget.href);

    }); 


})
    router();

    window.socket = new WebSocket(  App.WS_URL + "/ws");
    window.stompClient = Stomp.over(window.socket);
    const stompClient = window.stompClient;
    stompClient.connect({}, onConnect, onError);
    

    //serverResourceObserver.observe();
 

    function onConnect() {
        stompClient.subscribe("/app/ui/payload",message=>{console.log(message)});
        //console.log("Subscribe to the user's location updates " + destination);
        //stompClient.subscribe('', onMessageReceived);

    }
    //stompClient.send("geoplus/lol");
    
    //socket.send("HOIII!!")
})


// add handler
function onError(){

}


  


