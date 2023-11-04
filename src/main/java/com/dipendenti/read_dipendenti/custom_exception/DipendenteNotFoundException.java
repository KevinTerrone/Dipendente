package com.dipendenti.read_dipendenti.custom_exception;

public class DipendenteNotFoundException extends Exception{
    public DipendenteNotFoundException(){
        super("Non e' stato trovato alcun dipendente");
    }
}
