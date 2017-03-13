package com.ptm.tests;

import com.ptm.Frequency;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

public class FrequencyTest {

    private Frequency Analyzer = new Frequency();
    private String text;

    @Rule
    public final ExpectedException exception = ExpectedException.none();


    @Test
    public void test_frequency_of_letters() throws Exception {

        text = "This is a random text. This text is used to test the frequency of letters";
        assertEquals(4.0, Analyzer.analyze(text).find('i').get());
        exception.expect(Exception.class);
        exception.expectMessage("Text must be set");
        Analyzer.find('i').get();

    }


}
