package com.shakshi;

import java.util.List;

import com.shakshi.creditcard.CreditCard;
import com.shakshi.inputoutput.RecordInputOutput;
import com.shakshi.inputoutput.RecordInputOutputFactory;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Invalid syntax. Usage: java Main <input filename> <output filename>");
            System.exit(1);
        }

        String inputFilename = args[0];
        String outputFilename = args[1];
        Utils.validatePaths(inputFilename, outputFilename);
        RecordInputOutput io = new RecordInputOutputFactory().getRecordIO(inputFilename);
        List<CreditCard> creditCards = io.readFile(inputFilename);
        boolean writeSuccess = io.writeFile(outputFilename, creditCards);
        if (writeSuccess) {
            System.out.println("Output successfully written to " + outputFilename);
        } else {
            System.out.println("Failed to write output");
        }
    }
}