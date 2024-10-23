export default class conexion {
    constructor(name,dataLink,vehicle = null){
        this.name = name;
        this.dataLink = dataLink;
        this.vehicle = vehicle;
    }

    setName(name){
        this.name = name;
    }

    setDataLink(dataLink){
        this.dataLink = dataLink;
    }

    setVehicle(vehicle){
        this.vehicle = vehicle;
    }
}