package com.shakshi;

import org.junit.Test;

import com.shakshi.Utils;

import static org.junit.Assert.assertThrows;

public class UtilsTest {

    @Test
    public void test_validateTheFileExtension_notThrowOnValidExtensions() {
        Utils.validateTheFileExtension("input_file.csv", "output_file.csv");
    }

    @Test
    public void test_validateTheFileExtension_throwsErrorOnInvalidExtensions() {
        assertThrows(RuntimeException.class, () -> Utils.validateTheFileExtension("input_file.json", "output_file.csv"));
    }

    @Test
    public void test_validateInputPathIfExists_notThrowOnValidPath() {
        Utils.validateInputPathIfExists("src/main/resources/input_file.csv");
    }

    @Test
    public void test_validateInputPathIfExists_throwsOnInvalidPath() {
        assertThrows(RuntimeException.class, () -> Utils.validateInputPathIfExists("input1_file.csv"));
    }
}