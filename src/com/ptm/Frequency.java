package com.ptm;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by tudor on 3/13/2017.
 */
public class Frequency {

    private Map<Character, Integer> map = new HashMap<Character, Integer>();
    private String text = "";
    private Character character;
    public int totalCount = 0;

    public void Frequency() {
    }

    public void Frequency(String text) {
        this.text = text;
    }

    private Frequency analyze() {
        if(Objects.equals(this.text, "")){
            System.err.println("Text is empty");
            System.exit(255);
        }

        for (int i = 0; i < this.text.length(); i++) {
            this.totalCount++; //This is the total number of characters we've found in the output

            Integer countForCharacter = 0;
            //check in map if we have a count for this character
            if (map.containsKey(character)) {
                //get the current count we have for this character
                countForCharacter = map.get(this.character);
                //increment
                countForCharacter++;
                //increment the count
            } else {
                countForCharacter = 1;
            }

            //Now put the up to date count into the map
            map.put(this.character, countForCharacter);
        }

        return this;
    }


    public int getFrequencyOf(Character character) {

        return this.getFrequencyOf(character, false);
    }

    public int getFrequencyOf(Character character, String text) {
        this.text = text;

        return this.getFrequencyOf(character, false);
    }

    public double getFrequencyOf(Character character, String text, boolean percentage) {
        this.text = text;

        return this.getFrequencyOf(character, percentage);
    }

    public double getFrequencyOf(Character character, boolean percentage) {
        this.character = character;
        this.analyze();

        return (percentage) ? this.map.get(character) : this.map.get(character) / this.totalCount;
    }
}
