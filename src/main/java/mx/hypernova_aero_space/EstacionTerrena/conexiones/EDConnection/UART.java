package mx.hypernova_aero_space.EstacionTerrena.conexiones.EDConnection;

import java.io.IOException;
import java.util.HashSet;
import java.util.stream.Stream;

import com.serialpundit.core.SerialComException;
import com.serialpundit.serial.SerialComManager;
import com.serialpundit.serial.SerialComManager.BAUDRATE;
import com.serialpundit.serial.SerialComManager.DATABITS;
import com.serialpundit.serial.SerialComManager.FLOWCONTROL;
import com.serialpundit.serial.SerialComManager.PARITY;
import com.serialpundit.serial.SerialComManager.STOPBITS;

import mx.hypernova_aero_space.EstacionTerrena.conexiones.Link;




public  class UART implements Link{

    public static HashSet<String> usedPorts = new HashSet<>();
    //DEPENDENCIES
    private EDConnection ed_connection;
    //INTERNALS
    private String port;
    private BAUDRATE baud_rate;
    private DATABITS data_bits;
    private PARITY parity;
    private STOPBITS stop_bits;
    private FLOWCONTROL flow_control;
    private SerialComManager scm;
    private long handle;

    // public UART() throws IOException{
    //     usedPorts.add(port);
    //     scm = new SerialComManager();
    // }

    public UART(EDConnection ed_Connection,String port,BAUDRATE baud_rate,DATABITS data_bits, PARITY parity, 
    STOPBITS stop_bits,FLOWCONTROL flow_control) throws IOException{

        this.port = port;
        this.baud_rate =  baud_rate;
        this.data_bits = data_bits;
        this.parity = parity;
        this.stop_bits = stop_bits;
        this.flow_control = flow_control;
        this.ed_connection = ed_Connection;
        scm = new SerialComManager();
    }

    public static String[] verifyAvailablePorts(String[] ports){
        Stream<String> streamPorts = Stream.of(ports)
        .filter(str -> !UART.usedPorts.contains(str));
        return streamPorts.toArray(size -> new String[size]);
    }


    @Override
    public boolean conectar() throws IOException{
      
        try {
            handle = scm.openComPort(port, true, true, true);
            scm.configureComPortData(handle, data_bits, stop_bits, parity, baud_rate, 0);
            scm.configureComPortControl(handle, flow_control, 'x', 'x', false, false);
            scm.registerDataListener(handle, new UARTHandler(this,handle,scm));
            usedPorts.add(port);
            
        } catch (SerialComException ex) {
            throw new IOException(ex.getMessage(),ex);
        }
        return true;
    }

    public void setBaud_rate(BAUDRATE baud_rate) {
        this.baud_rate = baud_rate;
    }
    public  BAUDRATE getBaud_rate() {
        return baud_rate;
    }

    public void setPort(String port) {
        this.port = port;
    }
    public String getPort() {
        return port;
    }

    public void setData_bits(DATABITS data_bits) {
        this.data_bits = data_bits;
    }
    public DATABITS getData_bits() {
        return data_bits;
    }

    public void setParity(PARITY parity) {
        this.parity = parity;
    }
    public PARITY getParity() {
        return parity;
    }

    public void setFlow_control(FLOWCONTROL flow_control) {
        this.flow_control = flow_control;
    }
    public FLOWCONTROL getFlow_control() {
        return flow_control;
    }

    public void setStop_bits(STOPBITS stop_bits) {
        this.stop_bits = stop_bits;
    }
    public STOPBITS getStop_bits() {
        return stop_bits;
    }

    public void status(boolean status){
        ed_connection.setStatus(status);
    }

  
    @Override
    public void enviar(){

    }

    @Override
    public void escuchar(){
   
    }

    @Override
    public void interrumpir(){
       
    }

   


}
