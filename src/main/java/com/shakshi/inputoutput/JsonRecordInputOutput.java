package com.shakshi.inputoutput;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.shakshi.creditcard.CreditCard;
import com.shakshi.creditcard.CreditCardFactory;
import com.shakshi.creditcard.FetchCards;
import com.shakshi.creditcard.OutputRecord;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.json.JSONObject;

public class JsonRecordInputOutput implements RecordInputOutput {

    @Override
    public List<CreditCard> readFile(String filePath) {
//        List<CreditCard> records = new ArrayList<>();
//        File f = new File(filePath);
//        try (Reader reader = new FileReader(f)) {
//            MappingIterator<CreditCard> i = getJsonFileReader().readValues(reader);
//            while (i.hasNext()) {
//                CreditCard c = i.next();
//                records.add(c);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            InputStream json = FetchCards.class.getResourceAsStream("/input.json");
            FetchCards fetchCards = new ObjectMapper().readValue(json, FetchCards.class);
            return fetchCards.getCards();
        }
        catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public boolean writeFile(String filePath, List<CreditCard> data) {
//        File file = new File(filePath);
        List<OutputRecord> list = getOutputFileRecords(data);

        JSONObject json = new JSONObject();
        json.put("cards", list);

        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(json.toString());
            writer.close();
//            getJsonFileMapper().writeValue(file, json);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

//    private ObjectReader getJsonFileReader() {
//        return getJsonFileMapper().readerFor(CreditCard.class);
//    }

    private JsonMapper getJsonFileMapper() {
        JsonMapper m = new JsonMapper();
//        m.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
//        m.enable(SerializationFeature.INDENT_OUTPUT);
        return m;
    }

    private List<OutputRecord> getOutputFileRecords(List<CreditCard> creditCards) {
        return creditCards
                .stream()
                .map(r -> {
                    String number = r.getCardNumber();
                    try {
                        return new OutputRecord(
                                number,
                                new CreditCardFactory().getCreditCard(number).toString());
                    } catch (UnsupportedOperationException e) {
                        return new OutputRecord(
                                number,
                                e.getMessage()
                        );
                    }
                })
                .collect(Collectors.toList());
    }
}