package com.dipendenti.read_dipendenti.exception_hadler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractExceptionErrorHandler {
    private String info;
}
