package mx.hypernova_aero_space.EstacionTerrena.conexiones.EDConnection;

import com.serialpundit.core.SerialComException;
import com.serialpundit.serial.ISerialComDataListener;
import com.serialpundit.serial.SerialComManager;

import mx.hypernova_aero_space.EstacionTerrena.UI.uiCommunicator;
import mx.hypernova_aero_space.EstacionTerrena.data.Payload;

public class UARTHandler implements  ISerialComDataListener{

    private final UART uart;
    private final SerialComManager scm;
    private final long handle;

    public UARTHandler(UART uart,long handle,SerialComManager scm){
        this.uart = uart;
        this.handle = handle;
        this.scm = scm;
    }

    @Override
    public void onNewSerialDataAvailable(byte[] data){
        String lol = new String(data);
    
        System.out.println(lol);
        uiCommunicator.send(new Payload(lol));
    }

    @Override
    public void onDataListenerError(int errorNum){
        System.out.println("STOPPED!!!");
        uart.status(false);
        try {
            scm.unregisterDataListener(handle, this);
        } catch (SerialComException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
