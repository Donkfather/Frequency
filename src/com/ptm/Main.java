package com.ptm;

public class Main {

    public static void main(String[] args) {
        Frequency Analyzer = new Frequency();
        String text;
        text = "This is a random text. This text is used to test the frequency of letters";
        try {
            float result = Analyzer.analyze(text).find('i').get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
