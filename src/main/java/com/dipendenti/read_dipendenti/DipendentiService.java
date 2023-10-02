package com.dipendenti.read_dipendenti;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DipendentiService {

    private DipendentiRepository dipendentiRepository;
    private DipendenteDTO dipendenteDTO;
    private DipendenteEntity dipendenteEntity;

    public DipendenteDTO getDipendenteByID(String id) throws IOException {
        dipendenteEntity = dipendentiRepository.getDipendenteByCMatricolaORCFiscale(id);
        dipendenteDTO.setCodiceMatricola(dipendenteEntity.getCodiceMatricola());
        dipendenteDTO.setNome(dipendenteEntity.getNome());
        dipendenteDTO.setRuolo(dipendenteEntity.getRuolo());
        dipendenteDTO.setCognome(dipendenteEntity.getCognome());
        dipendenteDTO.setCodiceFiscale(dipendenteEntity.getCodiceFiscale());
        dipendenteDTO.setDataDiNascita(dipendenteEntity.getDataDiNascita());
        return dipendenteDTO;
    }

    public byte[] getDipendenti() throws IOException{
        return dipendentiRepository.getCSVFileWithAllDipendenti();
    }
}
