package com.dipendenti.read_dipendenti.controller;

import com.dipendenti.read_dipendenti.DTO.DipendenteDTO;
import com.dipendenti.read_dipendenti.service.DipendentiService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            log.info("Fine ricerca dipendente singolo");

        }catch (Exception e){
            log.info("Errore ricerca dipendente singolo {}",e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok(dipendenteDTO);
    }


    @GetMapping("/all")
    public ResponseEntity<byte[]> getCSVFile(){
        byte[] csvFile = null;

        try {
            log.info("Inizio ricerca dipendenti");
            csvFile = dipendentiService.getDipendenti();
            log.info("Fine ricerca dipendenti");
        }catch (Exception e){
            log.info("Errore ricerca dipendenti {}",e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok(csvFile);
    }

}
