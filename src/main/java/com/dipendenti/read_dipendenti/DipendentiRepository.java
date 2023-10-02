package com.dipendenti.read_dipendenti;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Repository
public class DipendentiRepository {

    // TODO: ottimizzare i metodi, ovvero estrarre la parte in comune per evitare la duplicazione del codice
    private final String documentPath = System.getProperty("user.home") + "/Documents";
    private final String documentName = "dipendenti.csv";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    public DipendenteEntity getDipendenteByCodiceMatricola(String codiceMatricola) throws IOException {
            Path csvDirectory = Paths.get(documentPath);
            Path csvPath = csvDirectory.resolve(documentName);

            CSVParser csvParser = CSVParser.parse(csvPath, Charset.defaultCharset(),
                    CSVFormat.DEFAULT.withHeader("Codice matricola", "Nome", "Cognome", "Codice fiscale", "Data di nascita'", "Ruolo" ));


            // CSV -> Stream
            Stream<CSVRecord> csvRecordStream = StreamSupport.stream(csvParser.spliterator(), false);

            // Stream -> List<String, String>
            List<Map<String, String>> rowList = csvRecordStream
                    .skip(1)
                    .map(CSVRecord::toMap)
                    .collect(Collectors.toList());


            logger.info(rowList.toString());

            // List<String, String> -> List<DipendenteEntity>
            List<DipendenteEntity> dipendenteEntityList = rowList
                    .stream()
                    .map(row -> new DipendenteEntity(row))
                    .filter(dipendente -> codiceMatricola.equals(dipendente.getCodiceMatricola()))
                    .collect(Collectors.toList());



            return dipendenteEntityList.isEmpty() ? new DipendenteEntity() : dipendenteEntityList.get(0);
        }

    public DipendenteEntity getDipendenteByCodiceFiscale(String codiceFiscale) throws IOException{
        Path csvDirectory = Paths.get(documentPath);
        Path csvPath = csvDirectory.resolve(documentName);

        CSVParser csvParser = CSVParser.parse(csvPath, Charset.defaultCharset(),
                CSVFormat.DEFAULT.withHeader("Codice matricola", "Nome", "Cognome", "Codice fiscale", "Data di Nascita'", "Ruolo" ));


        // CSV -> Stream
        Stream<CSVRecord> csvRecordStream = StreamSupport.stream(csvParser.spliterator(), false);

        // Stream -> List<String, String>
        List<Map<String, String>> rowList = csvRecordStream
                .skip(1)
                .map(CSVRecord::toMap)
                .collect(Collectors.toList());

        System.out.println(rowList);

        // List<String, String> -> List<DipendenteEntity>
        List<DipendenteEntity> dipendenteEntityList = rowList
                .stream()
                .map(row -> new DipendenteEntity(row))
                .filter(dipendente -> codiceFiscale.equals(dipendente.getCodiceFiscale()))
                .collect(Collectors.toList());


        return dipendenteEntityList.isEmpty() ? new DipendenteEntity() : dipendenteEntityList.get(0);
    }




    public byte[] getCSVFileWithAllDipendenti(){
        // TODO
        return null;
    }

}
