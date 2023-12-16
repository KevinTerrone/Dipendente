package com.dipendenti.read_dipendenti.controller_test;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class DipendentiControllerMockedFileCSVTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void  getSingoloDipendenteByCodiceMatricola_shouldReturn200Status_test() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/dipendenti/X000000")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void  getSingoloDipendenteCodiceFiscale_shouldReturn200Status_test() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/dipendenti/THJFSG0X000X000X")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void  getAllDipendenti_shouldReturn200Status_test() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/dipendenti/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
