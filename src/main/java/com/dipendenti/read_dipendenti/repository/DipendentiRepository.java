package com.dipendenti.read_dipendenti.repository;

import com.dipendenti.read_dipendenti.Entity.DipendenteEntity;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class DipendentiRepository {
    private final String documentPath = System.getProperty("user.home") + "/Documents";
    private final String documentName = "dipendenti.csv";

    public DipendenteEntity getDipendenteByCMatricolaORCFiscale(String id) throws IOException {
        Path csvDirectory = Paths.get(documentPath);
        Path csvPath = csvDirectory.resolve(documentName);

        CSVParser csvParser = CSVParser.parse(csvPath, Charset.defaultCharset(),
                                                CSVFormat.DEFAULT.withHeader("codiceMatricola", "nome", "cognome", "codiceFiscale", "dataDiNascita", "ruolo" ));

        List<DipendenteEntity> dipendenteEntityList = getListOfDipendenteEntityFromCSVParser(csvParser, id);


        return dipendenteEntityList.isEmpty() ? null : dipendenteEntityList.get(0);
    }


    public byte[] getCSVFileWithAllDipendenti() throws IOException{
        return Files.readAllBytes(Paths.get(documentPath+"\\"+documentName));
    }

    private List<DipendenteEntity> getListOfDipendenteEntityFromCSVParser(CSVParser csvParser, String id){
        List<DipendenteEntity> dipendenteEntityList  =  StreamSupport.stream(csvParser.spliterator(), false)
                .skip(1)
                .map(CSVRecord::toMap)
                .map(row -> new DipendenteEntity(row))
                .filter(dipendente -> id.equals(dipendente.getCodiceMatricola()) || id.equals(dipendente.getCodiceFiscale() ))
                .collect(Collectors.toList());

        return dipendenteEntityList;
    }

}
