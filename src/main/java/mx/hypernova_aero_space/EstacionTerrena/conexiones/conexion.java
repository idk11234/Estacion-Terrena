package mx.hypernova_aero_space.EstacionTerrena.conexiones;

import mx.hypernova_aero_space.EstacionTerrena.conexiones.AVConnection.AVConnection;
import mx.hypernova_aero_space.EstacionTerrena.conexiones.EDConnection.EDConnection;



public class conexion {

    private String name;
    private EDConnection dataLink;
    private AVConnection vehicle;

    public void synchronizeDataLink(){
        dataLink.synchronize();
    }

    //GETTERS
    public String getName() {
        return name;
    }

    public EDConnection getDataLink() {
        return dataLink;
    }

    public AVConnection getVehicle() {
        return vehicle;
    }

}

// class EnlaceED implements Enlace{

//     //void enviar(){}

// }
