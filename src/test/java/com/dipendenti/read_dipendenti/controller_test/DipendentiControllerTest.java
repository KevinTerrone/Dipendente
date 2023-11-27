package com.dipendenti.read_dipendenti.controller_test;

import com.dipendenti.read_dipendenti.custom_exception.DipendenteNotFoundException;
import com.dipendenti.read_dipendenti.dto.DipendenteDTO;
import com.dipendenti.read_dipendenti.entity.DipendenteEntity;
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
    void  getSingoloDipendenteByCodiceMatricola_shouldReturn204Status_test() throws Exception {
        when(mockService.getDipendenteByID(any())).thenThrow(DipendenteNotFoundException.class);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/dipendenti/A000001")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

    }

    @Test
    void  getSingoloDipendenteByCodiceMatricola_shouldReturn200Status_test() throws Exception {
        DipendenteDTO dipendenteDTO = new DipendenteDTO();
        dipendenteDTO.setCodiceMatricola("X000005");
        dipendenteDTO.setCodiceFiscale("PPPPPP0X000X000X");
        dipendenteDTO.setNome("Goku");
        dipendenteDTO.setCognome("Vegeta");
        dipendenteDTO.setDataDiNascita("01/05/2021");
        dipendenteDTO.setRuolo("consulente");

        when(mockService.getDipendenteByID(any())).thenReturn(dipendenteDTO);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/dipendenti/A000001")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
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
    void  getSingoloDipendenteByCodiceFiscale_shouldReturn204Status_test() throws Exception {
        when(mockService.getDipendenteByID(any())).thenThrow(DipendenteNotFoundException.class);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/dipendenti/PPPPPP0X000X000X")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    void  getSingoloDipendenteCodiceFiscale_shouldReturn200Status_test() throws Exception {
        DipendenteDTO dipendenteDTO = new DipendenteDTO();
        dipendenteDTO.setCodiceMatricola("X000005");
        dipendenteDTO.setCodiceFiscale("PPPPPP0X000X000X");
        dipendenteDTO.setNome("Goku");
        dipendenteDTO.setCognome("Vegeta");
        dipendenteDTO.setDataDiNascita("01/05/2021");
        dipendenteDTO.setRuolo("consulente");

        when(mockService.getDipendenteByID(any())).thenReturn(dipendenteDTO);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/dipendenti/PPPPPP0X000X000X")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
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