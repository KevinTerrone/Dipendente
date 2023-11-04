package com.dipendenti.read_dipendenti.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;


@Data
@NoArgsConstructor
public class DipendenteEntity {
    private String codiceMatricola;
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private String dataDiNascita;
    private String ruolo;

    public DipendenteEntity(Map<String, String> row){
        this.codiceMatricola = row.get("codiceMatricola");
        this.nome = row.get("nome");
        this.cognome = row.get("cognome");
        this.codiceFiscale = row.get("codiceFiscale");
        this.dataDiNascita = row.get("dataDiNascita");
        this.ruolo = row.get("ruolo");
    }
}
