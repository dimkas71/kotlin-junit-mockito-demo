package ua.compservice;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("English to pig test and vice versa...")
@Tag("Active")
class EnglishToPigTest {

    @Test
    @DisplayName("when a word with one symbol is translated then just the 'ay' suffix is added")
    void when_single_word_translated_then_ey_is_added() {
        String aWord = "t";
        Assertions.assertEquals("t" + EnglishToPig.SUFFIX, EnglishToPig.encode(aWord),  () -> "Should be equal to tey");
    }

    @Test
    @DisplayName("when input word is null then IllegalArgumentException should be thrown")
    void testNullInput() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            EnglishToPig.encode(null);
        });

        Assertions.assertEquals("Null argument", exception.getMessage());
    }

    @ParameterizedTest(name = "A word \"{0}\" translated to \"{1}\"")
    @CsvSource(value = {
            "t,tay",
            "a,aay",
            "at,taay",
            "the,hetay",
             "fox, oxfay"})
    void test_csv_source(String word, String expected) {
        Assertions.assertEquals(expected, EnglishToPig.encode(word), () -> "Should be equal");
    }

    @Test
    @DisplayName("when input word in decode method is null then IllegalArgumentException should be thrown")
    void testNullInputAtDecode() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            EnglishToPig.decode(null);
        });

        Assertions.assertEquals("Null argument", exception.getMessage());
    }

    @Test
    @DisplayName("when input is empty then IllegalArgumentException should  be thrown")
    void testEmptyInput() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            EnglishToPig.decode("");
        });
        Assertions.assertEquals(EnglishToPig.EMPTY_ARGUMENT, exception.getMessage(), () -> "Should not be empty");

    }

    @ParameterizedTest(name = "a decoded word \"{0}\", encoded one \"{1}\"")
    @CsvFileSource(resources = "/english-to-pig.csv", numLinesToSkip = 1)
    void testDecodingProcess(String decoded, String expected) {
        Assertions.assertEquals(expected, EnglishToPig.decode(decoded));
    }

}

