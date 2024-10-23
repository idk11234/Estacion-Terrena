package mx.hypernova_aero_space.EstacionTerrena.UI;

import java.util.HashMap;

import mx.hypernova_aero_space.EstacionTerrena.conexiones.conexion;
import mx.hypernova_aero_space.EstacionTerrena.conexiones.conexionManager;

public class uiConnections implements uiResource{

    private int usersCount = 0;
    private boolean active = false;
    private String resourceName = "connections";

    public static final uiConnections INSTANCE = new uiConnections();
    private HashMap<String,conexion> data;

    uiConnections(){
        data = conexionManager.getConnections();
    }

    @Override
    public void use(){
        active = true;
        usersCount++;
        sendUpdate();
    }

    @Override
    public void unUse(){
        usersCount--;
        if(usersCount <=0){
            usersCount = 0;
            active = false;
        }
    }

    @Override
    public void sendUpdate(){
        if(active){
           uiCommunicator.send(new uiData(resourceName, data));
        }
    }


    public void setActive(boolean active) {
        this.active = active;
    }

}
