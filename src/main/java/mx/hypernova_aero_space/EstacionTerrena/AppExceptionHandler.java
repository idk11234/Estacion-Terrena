package mx.hypernova_aero_space.EstacionTerrena;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler{

    // @ExceptionHandler(Exception.class)
    // protected ResponseEntity<Object> hande(IOException ex, HttpServletRequest request, HttpServletResponse response){

    //     System.out.println(ex.toString());
    //     ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), "lol git gud");
    //     return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    // }
}
