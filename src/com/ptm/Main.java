package com.ptm;

public class Main {

    public static void main(String[] args) {
	    Frequency Analyzer = new Frequency();
        String text;
        text = "This is such a bullshit";
//	    System.out.println(Analyzer.getFrequencyOf('i',text,true));
        Analyzer.analyze(text).find('i').toPercentage().get();
    }
}
