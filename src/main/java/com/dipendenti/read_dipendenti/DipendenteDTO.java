package com.dipendenti.read_dipendenti;

import lombok.Data;



@Data
public class DipendenteDTO {
    private String codiceMatricola;
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private String dataDiNascita;
    private String ruolo;
}
