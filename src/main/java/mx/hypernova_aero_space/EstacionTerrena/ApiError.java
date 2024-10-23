package mx.hypernova_aero_space.EstacionTerrena;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiError{

    private HttpStatus status;
    private String message;
    private List<String> errors;

    public ApiError(HttpStatus status, String message, List<String> errors) {
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ApiError(HttpStatus status, String message, String error) {
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public List<String> getErrors() {
        return errors;
    }

    public String getMessage() {
        return message;
    }
}
