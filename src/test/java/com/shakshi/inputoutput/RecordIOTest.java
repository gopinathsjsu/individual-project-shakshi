package com.shakshi.inputoutput;

import com.shakshi.creditcard.CreditCard;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class RecordIOTest {

    @Test
    public void test_readFromCsv() {
        String filePath = "src/main/resources/input_file.csv";
        RecordInputOutput recordIO = new RecordInputOutputFactory().getRecordIO(filePath);
        List<CreditCard> data = recordIO.readFile(filePath);
        CreditCard r = data.get(0);
        assertEquals("5567894523129089", r.getCardNumber());
        assertEquals("08/26", r.getExpirationDate());
        assertEquals("John Doe", r.getNameOfHolder());
    }

    @Test
    public void test_readFromXml() {
        String filePath = "src/main/resources/input_file.xml";
        RecordInputOutput recordIO = new RecordInputOutputFactory().getRecordIO(filePath);
        List<CreditCard> records = recordIO.readFile(filePath);
        CreditCard r = records.get(0);
        assertEquals("5567894523129089", r.getCardNumber());
        assertEquals("08/26", r.getExpirationDate());
        assertEquals("John DoE", r.getNameOfHolder());
    }

    @Test
    public void test_readFromJson() {
        String filePath = "src/main/resources/input_file.json";
        RecordInputOutput recordIO = new RecordInputOutputFactory().getRecordIO(filePath);
        List<CreditCard> records = recordIO.readFile(filePath);
        CreditCard r = records.get(0);
        assertEquals("5567894523129089", r.getCardNumber());
        assertEquals("08/26", r.getExpirationDate());
        assertEquals("John Doe", r.getNameOfHolder());
    }
}
