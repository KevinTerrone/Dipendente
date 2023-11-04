package com.dipendenti.read_dipendenti.dipendenti_AOP.controllerAdvice;

import com.dipendenti.read_dipendenti.custom_exception.DipendenteNotFoundException;
import com.dipendenti.read_dipendenti.custom_exception.GetDipendentiException;
import com.dipendenti.read_dipendenti.exception_hadler.DipendenteNotFoundExceptionHandler;
import com.dipendenti.read_dipendenti.exception_hadler.GenericDipendentiExceptionHandler;
import com.dipendenti.read_dipendenti.exception_hadler.GetDipendentiExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DipendentiControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<GenericDipendentiExceptionHandler> handleException(Exception exception)
    {
        GenericDipendentiExceptionHandler handler = new GenericDipendentiExceptionHandler();

        handler.setInfo(exception.getMessage());

        return new ResponseEntity<>(handler, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<GetDipendentiExceptionHandler> handleIOException(GetDipendentiException exception)
    {
        GetDipendentiExceptionHandler handler = new GetDipendentiExceptionHandler();

        handler.setInfo(exception.getMessage());

        return new ResponseEntity<>(handler, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<DipendenteNotFoundExceptionHandler> handleDipendenteNotFoundException(DipendenteNotFoundException exception)
    {
        DipendenteNotFoundExceptionHandler handler = new DipendenteNotFoundExceptionHandler();

        handler.setInfo(exception.getMessage());

        return new ResponseEntity<>(handler, HttpStatus.NOT_FOUND);
    }
}
