package com.dipendenti.read_dipendenti;

import com.dipendenti.read_dipendenti.controller.DipendentiController;
import com.dipendenti.read_dipendenti.service.DipendentiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DipendentiControllerTest {

    @MockBean
    DipendentiService mockService;

    @Autowired
    DipendentiController controller;
    @Test
    void getDipendenteById() {

    }

    @Test
    void getCSVFile() {
    }
}