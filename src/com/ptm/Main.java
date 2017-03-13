package com.ptm;

public class Main {

    public static void main(String[] args) throws Exception {
        Frequency Analyzer = new Frequency();
        String text;
        text = "This is a random text. This text is used to test the frequency of letters";
        float result = Analyzer.analyze(text).find('i').get();

    }
}
