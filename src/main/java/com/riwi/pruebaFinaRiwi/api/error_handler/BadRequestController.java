package com.riwi.pruebaFinaRiwi.api.error_handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.riwi.pruebaFinaRiwi.api.dto.erros.BaseErrorRep;
import com.riwi.pruebaFinaRiwi.api.dto.erros.ErrorResp;
import com.riwi.pruebaFinaRiwi.utils.exception.BadRequestException;

@RestControllerAdvice
public class BadRequestController {
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
   @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseErrorRep handleBadRequest(MethodArgumentNotValidException exception){

        List<Map<String,String>> errors = new ArrayList<>();
        /*
         * getBindingResult obtiene los resultados con el fiel y el error
         * getFieldErrors obtiene la lista de los nombres del campo del error 
         */
        exception.getBindingResult().getFieldErrors().forEach(e -> {
            Map<String,String> error = new HashMap<>();
            error.put("error", e.getDefaultMessage()); //agregar al map el error
            error.put("field", e.getField()); //agregar al map en donde ocurrió el error
            errors.add(error);
        });


        return ErrorResp.builder()
            .code(HttpStatus.BAD_REQUEST.value()) //400
            .status(HttpStatus.BAD_REQUEST.name()) //BAD_REQUEST
            .errors(errors) // [ { "field": "mal", "error": "mal"} ]
            .build();
    }


    @ExceptionHandler(BadRequestException.class)
    public ErrorResp handleError(BadRequestException exception){
        List<Map<String,String>> errors = new ArrayList<>();

        Map<String,String> error = new HashMap<>();
        
        error.put("id", exception.getMessage());

        errors.add(error);

        
        return ErrorResp.builder()
                .code(HttpStatus.BAD_REQUEST.value()) //400
                .status(HttpStatus.BAD_REQUEST.name()) //BAD_REQUEST
                .errors(errors) // [ { "field": "mal", "error": "mal"} ]
                .build();

    } 
}
