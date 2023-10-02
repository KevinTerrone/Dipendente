package com.dipendenti.read_dipendenti;

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
        this.codiceMatricola = row.get("Codice matricola");
        this.nome = row.get("Nome");
        this.cognome = row.get("Cognome");
        this.codiceFiscale = row.get("Codice fiscale");
        this.dataDiNascita = row.get("Data di nascita");
        this.ruolo = row.get("Ruolo");
    }
}
