package com.shakshi.inputoutput;

import java.util.List;

import com.shakshi.creditcard.CreditCard;

public interface RecordInputOutput {
    List<CreditCard> readFile(String filename);

    boolean writeFile(String filename, List<CreditCard> records);
}