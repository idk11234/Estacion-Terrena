package mx.hypernova_aero_space.EstacionTerrena.UI;

import com.serialpundit.core.SerialComException;
import com.serialpundit.serial.SerialComManager;

import mx.hypernova_aero_space.EstacionTerrena.conexiones.EDConnection.UART;

public class serialComPortListener implements Runnable, uiResource{
 
    private int usersCount = 0;
    private boolean active = false;
    private String resourceName = "COMPorts";

    public static final serialComPortListener INSTANCE = new serialComPortListener();
    private SerialComManager scm;
    private static Thread thread;
    private String[] ports;
 

    private serialComPortListener(){
        try {
            thread = new Thread(this,"serialComListener");
            scm = new SerialComManager();
            ports = scm.listAvailableComPorts();
            thread.start();
            System.out.println("COM LISTENER CREATED ^_^");
            
            
        } catch (Exception e) {
            //System.out.println("FAILED TO CRATE PORTLISTENER!! >.<");
        }
    }

    public void  seppuku(){
        System.out.println("NO LONGER LISTENING!! 0w0");
        active = false;
    }

    @Override
    public void use(){
        usersCount++;
        try { 
            ports = UART.verifyAvailablePorts(scm.listAvailableComPorts());
        } catch (SerialComException ex) {
        
        }
  
        sendUpdate();

        if(!thread.isAlive()){
            active = true;
            run();
        }     
    }

    @Override
    public void unUse(){
        usersCount--;
        if(usersCount == 0){
            seppuku();
        }
    }

    @Override
    public void sendUpdate(){
        uiCommunicator.send(new uiData(resourceName, ports));
    }

    @Override
    public void run() {
        int pastPortLength = 0;
        System.out.println("LISTENING 0w0!!");

        try {
            ports = UART.verifyAvailablePorts(scm.listAvailableComPorts());
            pastPortLength = ports.length;
        } catch (SerialComException ex) {
            pastPortLength = 0;
        }
        int i=0;
        while (active) {

            try {
                    try {
                        ports = UART.verifyAvailablePorts(scm.listAvailableComPorts());
                    } catch (SerialComException ex) {
                        ports = new String[]{};
                    }
                    
                   if(!(ports.length==pastPortLength)) {
                    System.out.println("SOMETHING CHANGED!!");
                    i++;
                    sendUpdate();
                   }
      
                
                   pastPortLength = ports.length;

                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
            //System.out.println("RUNIN!");
        }
        active = false;
        System.out.println("LISTENING FINISHED ^_^ !!");
    }
    

}
