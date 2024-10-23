package mx.hypernova_aero_space.EstacionTerrena.conexiones;

import java.io.IOException;
import java.util.HashMap;

import mx.hypernova_aero_space.EstacionTerrena.UI.uiConnections;

public class conexionManager{
    private static int numberOfConnections = 0;
    private static HashMap<String,conexion> connections = new HashMap<>();

    public static void add(conexion connection) throws IOException{
        connection.getDataLink().connect();
        connections.put(connection.getName(),connection);
        uiConnections.INSTANCE.sendUpdate();
        System.out.println("ADDDEDD CONNECTION!!");
    }

    public static void delete(conexion connection){
        connections.remove(connection.getName());
        //addevent
        uiConnections.INSTANCE.sendUpdate();
    }

    public static HashMap<String,conexion> getConnections(){
        return connections;
    }

    public conexion getConnection(String id) {
        return connections.get(id);
    }
}


