package mx.hypernova_aero_space.EstacionTerrena.conexiones;
import java.io.IOException;


public interface Link {
    boolean conectar() throws IOException;
    void escuchar();
    void enviar();  
    void interrumpir();
}
