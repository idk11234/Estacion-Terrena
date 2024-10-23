package mx.hypernova_aero_space.EstacionTerrena.UI;

import java.util.HashMap;






public final class uiResourcesManager {

    private static final HashMap<String,uiResource> uiResources = uiResources();

    public static void handle(uiRequestMessage resource){
        uiResource requestedResource = uiResources.get(resource.resource);   
        if(resource.use){
            requestedResource.use();
        }
        else{
            requestedResource.unUse();
        }
        

    }

    public static void unhandle(){

    }


    private static HashMap<String, uiResource> uiResources(){
        HashMap<String,uiResource> map = new HashMap<>();
        map.put("COMPorts",serialComPortListener.INSTANCE);
        map.put("connections",uiConnections.INSTANCE);
        return map;
    }

}


