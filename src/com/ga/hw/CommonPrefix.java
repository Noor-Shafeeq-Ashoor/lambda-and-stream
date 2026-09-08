package com.ga.hw;

public class CommonPrefix {

    public static String Prefix(String[] words) {
        if (words == null || words.length == 0) {return " ";}

        StringBuilder p = new StringBuilder();

        for (int i = 0; i < words[0].length(); i++) {
            char currentChar = words[0].charAt(i);

            for (int j = 1; j < words.length; j++) {
                if (i >= words[j].length() || words[j].charAt(i) != currentChar) { return p.toString(); }
            }
            p.append(currentChar);
        }
        return p.toString();
    }

    public static void main(String[] args) {

        System.out.println( Prefix( new String[]{"flower", "flow", "flight"} ));

        System.out.println(Prefix( new String[]{"dog", "racecar", "car"}));
    }
}
