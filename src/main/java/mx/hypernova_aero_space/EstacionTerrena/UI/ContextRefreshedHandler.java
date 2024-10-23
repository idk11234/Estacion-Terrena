package mx.hypernova_aero_space.EstacionTerrena.UI;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class ContextRefreshedHandler implements ApplicationListener<ContextRefreshedEvent>{

    //private static Logger logger = LoggerFactory.getLogger(ContextRefreshedHandler.class);

  @Autowired
  private SimpMessagingTemplate template;

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    try {
      //Initialize the template for web socket messages
      uiCommunicator.setTemplate(template);
    } catch (Exception ex) {
     // logger.error(getClass().getName(), ex);
    }
  }

}
