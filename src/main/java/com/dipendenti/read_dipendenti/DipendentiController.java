package com.dipendenti.read_dipendenti;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dipendenti")
public class DipendentiController {

    @GetMapping("/{id}")
    public ResponseEntity<DipendenteDTO> getDipendenteById(@PathVariable String id){

        DipendenteDTO dipendenteDTO = new DipendenteDTO();

        dipendenteDTO.setCodiceMatricola(id);

        return ResponseEntity.ok(dipendenteDTO);
    }

}
