package mx.hypernova_aero_space.EstacionTerrena;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;




@Controller
//@RequestMapping("/api/conexion")
public class appController{
    @Value("${spring.application.name}")
    String appName;
    //private final conexionController conexionController;

    // public conexionController(){
    //     this.conexionController = new conexionController();
    // }


    // @GetMapping("*")
    //  public String getMethodName(Model model) {
    //     model.addAttribute("appName", appName);
    //     System.out.println(model);
    //     return "index";
    //}

    

    
    // @ExceptionHandler({NoHandlerFoundException.class})
    // public ResponseEntity<ErrorResponse> handleNoHandlerFoundException(
    //         NoHandlerFoundException ex, HttpServletRequest httpServletRequest) {
    //     System.out.println("No handler found exception");
    //     ErrorResponse error = new ErrorResponse("An error occurred: " + ex.getMessage());
    //     return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).body(error);
    // }

    
    
}