package mx.hypernova_aero_space.EstacionTerrena.UI;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/api/conexion")
public class uiControllers{
    @Value("${spring.application.name}")
    String appName;

    @Autowired
    private SimpMessagingTemplate template;
    //private final conexionController conexionController;

    // public conexionController(){
    //     this.conexionController = new conexionController();
    // }

    @GetMapping("/pupu")
     public String getMethodName(Model model) {
        model.addAttribute("appName", appName);
        System.out.println("HOIIII :3");
        return "redirect:/";
    }

  
    @MessageMapping("ui")
    public void idk(@Payload uiRequestMessage message){
        uiResourcesManager.handle(message);
    }
}


class uiRequestMessage implements Serializable {
    public String resource;
    public boolean use;
}