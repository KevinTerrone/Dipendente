package com.dipendenti.read_dipendenti;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dipendenti")
public class DipendentiController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DipendentiService dipendentiService;
    @GetMapping("/{id}")
    public ResponseEntity<DipendenteDTO> getDipendenteById(@PathVariable String id){

        DipendenteDTO dipendenteDTO = null;

        try {
            dipendenteDTO = dipendentiService.getDipendenteByID(id);
        }catch (Exception e){
            logger.info(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok(dipendenteDTO);
    }


    @GetMapping("/all")
    public ResponseEntity<byte[]> getCSVFile(){
        byte[] csvFile = null;

        try {
            csvFile = dipendentiService.getDipendenti();
        }catch (Exception e){
            logger.info(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok(csvFile);
    }

}
