package com.dipendenti.read_dipendenti.controller;

import com.dipendenti.read_dipendenti.dto.DipendenteDTO;
import com.dipendenti.read_dipendenti.custom_exception.DipendenteNotFoundException;
import com.dipendenti.read_dipendenti.custom_exception.GetDipendentiException;
import com.dipendenti.read_dipendenti.service.DipendentiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/dipendenti")
@Slf4j
public class DipendentiController {

    @Autowired
    private DipendentiService dipendentiService;
    @GetMapping("/{id}")
    public ResponseEntity<DipendenteDTO> getDipendenteById(@PathVariable String id) throws Exception {

        DipendenteDTO dipendenteDTO = null;

        try {
            log.info("Inizio ricerca dipendente singolo");
            dipendenteDTO = dipendentiService.getDipendenteByID(id);
        }catch (DipendenteNotFoundException e){
            log.error(e.getMessage());
            throw new DipendenteNotFoundException();
        }catch (IOException e){
            log.error("Errore I/O ricerca dipendente singolo: {}",e.getMessage());
            throw new GetDipendentiException("Errore I/O ricerca dipendente singolo: " + e.getMessage());
        }catch (Exception e){
            log.error("Errore generico ricerca dipendente singolo: {}",e.getMessage());
            throw new Exception("Errore generico ricerca dipendente singolo: " + e.getMessage());
        }

        log.info("Fine ricerca dipendente singolo");
        return ResponseEntity.ok(dipendenteDTO);
    }


    @GetMapping("/all")
    public ResponseEntity<byte[]> getCSVFile() throws Exception {
        byte[] csvFile = null;

        try {
            log.info("Inizio download file dipendenti");
            csvFile = dipendentiService.getDipendenti();
        }catch (IOException e){
            log.error("Errore I/O durante download file dipendenti: ",e.getMessage());
            throw new GetDipendentiException("Errore I/O durante download file dipendenti: " + e.getMessage());
        }catch (Exception e){
            log.error("Errore generico durante download file dipendenti: ",e.getMessage());
            throw new Exception("Errore generico durante download file dipendenti: " + e.getMessage());
        }

        log.info("Fine download file dipendenti");
        return ResponseEntity.ok(csvFile);
    }



}
