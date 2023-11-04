package com.dipendenti.read_dipendenti;

import com.dipendenti.read_dipendenti.service.DipendentiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
class DipendentiControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    DipendentiService mockService;

    //----------------------------------------
    // Test getSingoloDipendenteByCodiceMatricola
    @Test
    void getSingoloDipendenteByCodiceMatricola_shouldReturn500Status_test() throws Exception {

        when(mockService.getDipendenteByID(any())).thenThrow(Exception.class);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/dipendenti/A000001")
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isInternalServerError());
    }

    @Test
    void  getSingoloDipendenteByCodiceMatricola_shouldReturn404Status_test(){

    }

    @Test
    void  getSingoloDipendenteByCodiceMatricola_shouldReturn200Status_test(){

    }

    //----------------------------------------
    // Test getSingoloDipendenteByCodiceFiscale
    @Test
    void getSingoloDipendenteByCodiceFiscale_shouldReturn500Status_test() throws Exception {
        when(mockService.getDipendenteByID(any())).thenThrow(Exception.class);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/dipendenti/PPPPPP0X000X000X")
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isInternalServerError());
    }

    @Test
    void  getSingoloDipendenteByCodiceFiscale_shouldReturn404Status_test(){

    }

    @Test
    void  getSingoloDipendenteCodiceFiscale_shouldReturn200Status_test(){

    }


    // Test getAllDipendenti
    @Test
    void  getAllDipendenti_shouldReturn500Status_test() throws Exception {
        when(mockService.getDipendenti()).thenThrow(Exception.class);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/dipendenti/all")
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isInternalServerError());
    }

    @Test
    void  getAllDipendenti_shouldReturn200Status_test() throws Exception {

        when(mockService.getDipendenti()).thenReturn(new byte[100]);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/dipendenti/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}