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
        assertNotEquals(3.0,Analyzer.analyze(text).find('i').get());

        text = "Rules were called Interceptors when they made their";
        assertEquals(1.0, Analyzer.analyze(text).find('i').get());

        text = "More information on these features is available in the JUnit 4.7 release notes.  Hamcrest 1.2 support was listed in earlier";
        assertEquals(9.0, Analyzer.analyze(text).find('i').get());

        text = "While you're waiting for the final release, you can download the release candidate from github, browse org.junit.rules gear";
        assertEquals(7.0, Analyzer.analyze(text).find('i').get());

        text = "I've written TemporaryFolder-like code lots of times, so I'm definitely looking forward to this. Although, I admit that there are places I'd like more customization -- such as if a temporary folder is needed for some test ";
        assertEquals(13.0, Analyzer.analyze(text).find('i').get());

        text = "a";
        assertEquals(0.0, Analyzer.analyze(text).find('i').get());

        try {
            Analyzer.find('i').get();
        } catch (Exception e) {
            assertEquals("Text is not set", e.getMessage());
        }

    }


}
