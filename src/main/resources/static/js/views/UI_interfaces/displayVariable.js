import gyroscopeData from "../../dataTypes/gyroscopeData.js";
import payloadHandler from "../../utils/payloadHandler.js";

export default class displayVariable{
    chart;
    container;
    typeDisplay;
    style;
    varibleToMeasure;
    legends;
    html;

    #config;

    constructor(creationObject){

        try{
            this.container = creationObject.container;
            this.typeDisplay = creationObject.typeDisplay;
            this.style = creationObject.style;
            this.varibleToMeasure = creationObject.varibleToMeasure;

            this.html = this.getHTML();

            this.#config = {
                type: 'time.line',
                data: [],
                axes: ['left', 'bottom']
            };

            for(let channel in this.varibleToMeasure.data){
                    this.#config.data.push({label:channel,values: this.varibleToMeasure.data[channel]})
                //this.#config.data.datasets[1].label = "lol";
            }
        }
        catch(e){
            console.log(e);
        }
    }

    getHTML(){
        const canvas = document.createElement("div");
        canvas.style.height = "100%";
        canvas.style.width = "100%";
        canvas.setAttribute("class","epoch category10");
         return canvas;
    }

    async render(){
        const container = document.getElementById(this.container);

        const div = document.createElement("div");
        div.setAttribute('class','variable_display');

        const tittle = document.createElement("div");
        tittle.setAttribute("class","graph-tittle");
        tittle.innerText = this.varibleToMeasure.toString();

        const legend = document.createElement("div");
        legend.setAttribute("class","graph-legend");

        Payload[this.varibleToMeasure].forEach(channel => {
            legend.appendChild(document.createElement("div").setAttribute("data-legend",channel.toString()));
        });
        // tittle.innerText = ;
        
        
        div.appendChild(tittle);
        div.appendChild(this.html);


        container.append(div);    
        this.chart = $(this.html).epoch(this.#config);       
        payloadHandler.inUse(this);
        
        // await this.chart.render();
    }

    update(data){
        const series =[]
        const payload = data.payload;

        for(let channel in payload){
            series.push({x:this.index,y:payload[channel]})
        }
       // this.chart.updateSeries(series)
        this.chart.push(series);
        this.index++;
    }
}