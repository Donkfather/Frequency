package com.ptm.tests;

import com.ptm.Frequency;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FrequencyTest {

    private Frequency Analyzer = new Frequency();
    private String text;

    @Test
    public void test_frequency_of_letters() throws Exception {

        text = "I've written TemporaryFolder-like code lots of times, so I'm definitely looking forward to this. Although, " +
                "I admit that there are places I'd like more customization -- such as if a temporary folder is needed for some test ";
        assertEquals(6.0, Analyzer.analyze(text).find('f').getFrequency());
        assertNotEquals(3.0,Analyzer.analyze(text).find('e').getFrequency());
        assertEquals(9.0, Analyzer.analyze(text).find('d').getFrequency());
        assertEquals(4.0, Analyzer.analyze(text).find('c').getFrequency());
        assertEquals(0.0, Analyzer.analyze(text).find('b').getFrequency());
        assertEquals(10.0, Analyzer.analyze(text).find('a').getFrequency());
        assertEquals(0.0, Analyzer.analyze(text).find(' ').getFrequency());

        try {
            Analyzer.find('i').getFrequency();
        } catch (Exception e) {
            assertEquals("Text is not set", e.getMessage());
        }

    }

    @Test
    public void test_frequency_in_percentage_of_letters() throws Exception {
        text = "I've written TemporaryFolder-like code lots of times, so I'm definitely looking forward to this. Although, " +
                "I admit that there are places I'd like more customization -- such as if a temporary folder is needed for some test ";
        Frequency Analyzer2 = new Frequency(text,'f',true);
        assertEquals(3.2432432174682617, Analyzer2.getFrequency());
        assertNotEquals(12.5,Analyzer2.find('e').toPercentage().getFrequency());
    }
}



















