package com.dipendenti.read_dipendenti;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dipendenti")
public class DipendentiController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/{id}")
    public ResponseEntity<DipendenteDTO> getDipendenteById(@PathVariable String id){

        DipendenteDTO dipendenteDTO = new DipendenteDTO();

        dipendenteDTO.setCodiceMatricola(id);

        return ResponseEntity.ok(dipendenteDTO);
    }


    // TODO: da implementare
/*    @GetMapping("/all")
    public ResponseEntity<byte[]> getCSVFile(){
        return null;
    }*/

}
