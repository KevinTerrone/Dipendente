package com.dipendenti.read_dipendenti;

import com.dipendenti.read_dipendenti.controller.DipendentiController;
import com.dipendenti.read_dipendenti.service.DipendentiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
class DipendentiControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    DipendentiService mockService;

    // Test getSingoloDipendenteByCodiceMatricola
    @Test
    void getSingoloDipendenteByCodiceMatricola_shouldReturn500Status_test(){

    }

    @Test
    void  getSingoloDipendenteByCodiceMatricola_shouldReturn404Status_test(){

    }

    @Test
    void  getSingoloDipendenteByCodiceMatricola_shouldReturn200Status_test(){

    }


    // Test getSingoloDipendenteByCodiceFiscale
    @Test
    void getSingoloDipendenteByCodiceFiscale_shouldReturn500Status_test(){

    }

    @Test
    void  getSingoloDipendenteByCodiceFiscale_shouldReturn404Status_test(){

    }

    @Test
    void  getSingoloDipendenteCodiceFiscale_shouldReturn200Status_test(){

    }


    // Test getAllDipendenti
    @Test
    void  getAllDipendenti_shouldReturn500Status_test(){

    }


}