package mx.hypernova_aero_space.EstacionTerrena.UI;

import java.io.Serializable;
import java.util.List;

import javax.naming.event.ObjectChangeListener;

public class uiData{
    String name;
    Object data;

    public uiData(String name, Object data){
        this.name = name;
        this.data = data;
    }

    public uiData(String name, String[] data){
        this.name = name;
        this.data = data;
    }

    public uiData(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Object getData() {
        return data;
    }
}
