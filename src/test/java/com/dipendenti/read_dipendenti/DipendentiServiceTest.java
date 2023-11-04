package com.dipendenti.read_dipendenti;

import com.dipendenti.read_dipendenti.Entity.DipendenteEntity;
import com.dipendenti.read_dipendenti.custom_exception.DipendenteNotFoundException;
import com.dipendenti.read_dipendenti.repository.DipendentiRepository;
import com.dipendenti.read_dipendenti.service.DipendentiService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class DipendentiServiceTest {

    @MockBean
    DipendentiRepository mockRepository;


    @Autowired
    DipendentiService service;



    @Test
    void getDipendenteByID_NotFoundTest() throws Exception {
        when(mockRepository.getDipendenteByCMatricolaORCFiscale(any())).thenReturn(null);
        assertThrows(DipendenteNotFoundException.class, () -> {service.getDipendenteByID("A000001");});
        assertThrows(DipendenteNotFoundException.class ,() -> {service.getDipendenteByID("CCCPPP0X000X000X");});
    }

    @Test
    void getDipendenteByID_DoFoundTest() throws Exception {

        DipendenteEntity entity = new DipendenteEntity();
        entity.setCodiceMatricola("X000005");
        entity.setNome("Goku");
        entity.setCognome("Vegeta");
        entity.setDataDiNascita("01/05/2021");
        entity.setRuolo("consulente");


        when(mockRepository.getDipendenteByCMatricolaORCFiscale(any())).thenReturn(entity);
        assertNotNull(service.getDipendenteByID("X000005"));
        assertNotNull(service.getDipendenteByID("GGGVVV0X000X000X"));
    }

}