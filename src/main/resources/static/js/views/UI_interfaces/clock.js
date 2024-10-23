export default class clock{

    static users = [] ;


    constructor(contenedor){
        this.html = document.createElement("div");
        this.html.setAttribute("class","clock");


        this.parent = contenedor;

        
      
    }
    
    static showTime(){
        var date = new Date();
        var h = date.getHours(); // 0 - 23
        var m = date.getMinutes(); // 0 - 59
        var s = date.getSeconds(); // 0 - 59
        var session = "AM";
        
        if(h == 0){
            h = 12;
        }
        
        if(h > 12){
            h = h - 12;
            session = "PM";
        }
        
        h = (h < 10) ? "0" + h : h;
        m = (m < 10) ? "0" + m : m;
        s = (s < 10) ? "0" + s : s;
        
        var time = h + ":" + m + ":" + s + " " + session;
        let users = document.getElementsByClassName("clock");

        try{
            for (let element of users){
                element.innerHTML = time;
                element.textContent = time;
            }
        }
        catch(e){
        }   
    }

    render(){
        const parent = document.getElementById(this.parent);	
        parent.appendChild(this.html);
    }
}

