package com.ptm;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Frequency {

    private Map<Character, Integer> map = new HashMap<>();
    private String text = "";
    private Character character = null;
    private boolean percentage = false;
    private int totalCount = 0;

    public Frequency() {
    }

    public Frequency(String text, Character character, boolean percentage) {
        this.text = text;
        this.character = character;
        this.percentage = percentage;

    }

    private Frequency run() {
        this.reset();

        for (int i = 0; i < this.text.length(); i++) {
            Character currentCharacter = this.text.charAt(i);
            if (currentCharacter.equals(' ')) {
                continue;
            }

            this.totalCount++; //This is the total number of characters we've found in the output

            Integer countForCharacter = 0;
            //check in map if we have a count for this character
            if (map.containsKey(currentCharacter)) {
                //get the current count we have for this character
                countForCharacter = map.get(currentCharacter);
                //increment
                countForCharacter++;
                //increment the count
            } else {
                countForCharacter = 1;
            }
            //Now put the up to date count into the map
            map.put(currentCharacter, countForCharacter);
        }

        return this;
    }

    private Frequency validate() throws Exception {
        if (Objects.equals(this.text, "")) {
            System.err.println("Text must be set");
            throw new Exception("Text must be set");
        }
        if (this.character == null) {
            System.err.println("A character must be given");
            throw new Exception("A character must be given");
        }

        return this;
    }

    public Frequency analyze(String text) {
        this.text = text;

        return this;
    }

    public Frequency find(Character character) {
        this.character = character;

        return this;
    }

    Frequency toPercentage() {
        this.percentage = true;

        return this;
    }

    private void reset() {
        this.totalCount = 0;
        map.clear();
        this.percentage = false;
    }

    public float get() throws Exception {
        float out;

        this.validate().run();

        if (this.map.containsKey(this.character)) {
            if (this.percentage) {
                out = (this.map.get(this.character) * 100.0f / this.totalCount);
            } else {
                out = this.map.get(this.character);
            }
        }else{
            out = 0;
        }

        this.reset();

        return out;
    }
}
