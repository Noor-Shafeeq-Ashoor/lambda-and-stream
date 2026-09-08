package com.ga.hw;

public class CommonPrefix {

    public static String longestCommonPrefix(String[] words) {
        if (words == null || words.length == 0) {return "";}

        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < words[0].length(); i++) {
            char currentChar = words[0].charAt(i);

            for (int j = 1; j < words.length; j++) {
                if (i >= words[j].length()
                        || words[j].charAt(i) != currentChar) {

                    return prefix.toString();
                }
            }
            prefix.append(currentChar);
        }
        return prefix.toString();
    }

    public static void main(String[] args) {

        System.out.println(
                longestCommonPrefix( new String[]{"flower", "flow", "flight"} ));

        System.out.println(
                longestCommonPrefix( new String[]{"dog", "racecar", "car"}));
    }
}