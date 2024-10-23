import gyroscopeData from "../../dataTypes/gyroscopeData.js";
import clock from "../UI_interfaces/clock.js";
import displayVariable from "../UI_interfaces/displayVariable.js";
import View from "./View.js";

export default class VisualizadorView{

    constructor(){
  
        const UIObjects = [
            new displayVariable({
                container: "dashboard",
                typeDisplay: "lol",
                style: "none",
                varibleToMeasure: gyroscopeData
            }),
            new displayVariable({
                container: "dashboard",
                typeDisplay: "lol",
                style: "none",
                varibleToMeasure: gyroscopeData
            }),
            new displayVariable({
                container: "dashboard",
                typeDisplay: "lol",
                style: "none",
                varibleToMeasure: gyroscopeData
            }),
            new clock("vis-header"),
                
        ]

        View.create("visualizador",UIObjects);
   
    }
    

}