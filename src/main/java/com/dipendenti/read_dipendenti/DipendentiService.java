package com.dipendenti.read_dipendenti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DipendentiService {

    @Autowired
    private DipendentiRepository dipendentiRepository;


    public DipendenteDTO getDipendenteByID(String id) throws IOException {
        DipendenteDTO dipendenteDTO = new DipendenteDTO();
        DipendenteEntity dipendenteEntity = dipendentiRepository.getDipendenteByCMatricolaORCFiscale(id);
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
