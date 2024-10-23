package mx.hypernova_aero_space.EstacionTerrena.conexiones.EDConnection;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.serialpundit.serial.SerialComManager.BAUDRATE;
import com.serialpundit.serial.SerialComManager.DATABITS;
import com.serialpundit.serial.SerialComManager.FLOWCONTROL;
import com.serialpundit.serial.SerialComManager.PARITY;
import com.serialpundit.serial.SerialComManager.STOPBITS;

import mx.hypernova_aero_space.EstacionTerrena.conexiones.Link;

enum Protocol{
    UART,WIFI,BLUETOOTH
}

public class EDConnection implements Serializable{

    private boolean status;
    private Protocol protocol;
    private Link dataLink;

    public EDConnection(){
        status = false;
    }

    public void connect() throws IOException{
            dataLink.conectar();
            synchronize();
    }

    public void synchronize(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
        }
    }


    //manual Mapping (SUCKS!)
    @JsonProperty("config")
    private void getConfig(Map<String,String> config){
        switch (protocol) {
            case UART:
            {                    
                String port =  (String)config.get("port");
                BAUDRATE baud_rate = BAUDRATE.valueOf(config.get("baud_rate"));
                DATABITS data_bits = DATABITS.valueOf(config.get("data_bits"));
                PARITY parity = PARITY.valueOf(config.get("parity"));
                STOPBITS stop_bits = STOPBITS.valueOf(config.get("stop_bits"));
                FLOWCONTROL flow_control = FLOWCONTROL.valueOf(config.get("flow_control"));

                try {
                    dataLink = new UART(this,port, baud_rate, data_bits, parity, stop_bits, flow_control);
                } catch (IOException ex) {
                        ex.printStackTrace();
                        status = false;
                }
                break;
            }
                

            default:
                throw new AssertionError();
        }
    }

    //GETTERS

    public boolean getStatus() {
        return status;
    }

    public Link getDataLink() {
        return dataLink;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    //SETTERS
    public void setStatus(boolean status) {
        this.status = status;
    }

}



