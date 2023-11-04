package com.dipendenti.read_dipendenti.service;

import com.dipendenti.read_dipendenti.dto.DipendenteDTO;
import com.dipendenti.read_dipendenti.entity.DipendenteEntity;
import com.dipendenti.read_dipendenti.custom_exception.DipendenteNotFoundException;
import com.dipendenti.read_dipendenti.repository.DipendentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DipendentiService {

    @Autowired
    private DipendentiRepository dipendentiRepository;


    public DipendenteDTO getDipendenteByID(String id) throws Exception {
        DipendenteDTO dipendenteDTO = null;
        DipendenteEntity dipendenteEntity = dipendentiRepository.getDipendenteByCMatricolaORCFiscale(id);

        if(dipendenteEntity != null){
            dipendenteDTO = new DipendenteDTO();
            dipendenteDTO.setCodiceMatricola(dipendenteEntity.getCodiceMatricola());
            dipendenteDTO.setNome(dipendenteEntity.getNome());
            dipendenteDTO.setRuolo(dipendenteEntity.getRuolo());
            dipendenteDTO.setCognome(dipendenteEntity.getCognome());
            dipendenteDTO.setCodiceFiscale(dipendenteEntity.getCodiceFiscale());
            dipendenteDTO.setDataDiNascita(dipendenteEntity.getDataDiNascita());
        }else {
            throw new DipendenteNotFoundException();
        }

        return dipendenteDTO;
    }

    public byte[] getDipendenti() throws Exception{
        return dipendentiRepository.getCSVFileWithAllDipendenti();
    }
}
