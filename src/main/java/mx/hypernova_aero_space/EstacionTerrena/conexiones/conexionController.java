package mx.hypernova_aero_space.EstacionTerrena.conexiones;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.hypernova_aero_space.EstacionTerrena.ApiError;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
//@RequestMapping("/api/conexion")
public class conexionController{
    //private final conexionController conexionController;

    // public conexionController(){
    //     this.conexionController = new conexionController();
    // }
    @GetMapping("conexiones/launch")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    @GetMapping("conexiones")
    public String getMethodName() {
        return new String();
    }
    

    @PostMapping("conexiones")
     public void getMethodName(@RequestBody conexion connection) throws IOException {

        conexionManager.add(connection);
   

       try {
        Thread.sleep(2000);
        } catch (InterruptedException ex) {
        }
    }

    @ExceptionHandler()
    protected ResponseEntity<Object> hande(IOException ex, HttpServletRequest request, HttpServletResponse response){

        System.out.println(ex.toString());
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST,"",ex.getLocalizedMessage());
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    
    
}
