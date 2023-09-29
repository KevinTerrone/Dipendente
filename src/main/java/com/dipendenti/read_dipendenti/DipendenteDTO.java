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

    public String getCodiceMatricola() {
        return codiceMatricola;
    }

    public void setCodiceMatricola(String codiceMatricola) {
        this.codiceMatricola = codiceMatricola;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(String dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }
}
