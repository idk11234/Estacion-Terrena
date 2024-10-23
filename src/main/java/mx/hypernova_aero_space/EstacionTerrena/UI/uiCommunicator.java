package mx.hypernova_aero_space.EstacionTerrena.UI;

import org.springframework.messaging.Message;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import mx.hypernova_aero_space.EstacionTerrena.data.Payload;

public class uiCommunicator {
    private static SimpMessagingTemplate template;
    
    public static void setTemplate(SimpMessagingTemplate tmplt){
        template = tmplt;
    }

    public static void send(uiData data){
        template.convertAndSend("/app/ui/"+data.name,data);
    }

    public static void send(Payload payload){
        template.convertAndSend("/app/payload",payload);
    }
}
