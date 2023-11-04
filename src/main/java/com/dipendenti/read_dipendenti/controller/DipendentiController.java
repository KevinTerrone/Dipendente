package com.dipendenti.read_dipendenti.controller;

import com.dipendenti.read_dipendenti.DTO.DipendenteDTO;
import com.dipendenti.read_dipendenti.custom_exception.GetDipendentiException;
import com.dipendenti.read_dipendenti.service.DipendentiService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/dipendenti")
@Slf4j
public class DipendentiController {

    @Autowired
    private DipendentiService dipendentiService;
    @GetMapping("/{id}")
    public ResponseEntity<DipendenteDTO> getDipendenteById(@PathVariable String id){

        DipendenteDTO dipendenteDTO = null;

        try {
            log.info("Inizio ricerca dipendente singolo");
            dipendenteDTO = dipendentiService.getDipendenteByID(id);


        }catch (Exception e){
            log.info("Errore ricerca dipendente singolo {}",e.getMessage());
            return ResponseEntity.internalServerError().build();
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
            log.info("Errore I/O durante download file dipendenti",e.getMessage());
            throw new GetDipendentiException("Errore I/O durante download file dipendenti " + e.getMessage());
        }catch (Exception e){
            log.info("Errore generico durante download file dipendenti",e.getMessage());
            throw new Exception("Errore generico durante download file dipendenti " + e.getMessage());
        }

        log.info("Fine download file dipendenti");
        return ResponseEntity.ok(csvFile);
    }
    
}
