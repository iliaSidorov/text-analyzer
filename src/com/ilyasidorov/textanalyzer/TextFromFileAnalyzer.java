package com.ilyasidorov.textanalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFromFileAnalyzer {

    private static List<String> words = new ArrayList<>();
    private static Map<String, Integer> countMap = new TreeMap<>(String::compareToIgnoreCase);

    //display stats according to Task 2
    public void analyze(String filePath) throws IOException {
        Map<String, Integer> countMap = countWordFrequency(parseFileIntoList(filePath));
        displayStats(countMap);
        System.out.println();
        findMaxFrequentWord(countMap);
    }

    //get every word of the passed file excluding non-lexical symbols and collect it to a list
    private static List<String> parseFileIntoList(String filePath) throws IOException {
        String strFromFile = new String(Files.readAllBytes(Paths.get(filePath)));
        Pattern pattern = Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS | Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(strFromFile);
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }

    //count how many times a single word appears in a list and form a sorted map with it
    private static Map<String, Integer> countWordFrequency(List<String> words) {
        for (String word : words) {
            if (!countMap.containsKey(word))
                countMap.put(word, 0);

            countMap.put(word, countMap.get(word) + 1);
        }
        return countMap;
    }

    //display word(s) with max frequency
    private static void findMaxFrequentWord(Map<String, Integer> countMap) {
        int maxValue = Collections.max(countMap.values());
        System.out.println("More frequent word(s):");
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == maxValue) {
                System.out.println(entry.getKey() + " - " + entry.getValue() + " times");
            }
        }
    }

    //show statistics
    private static void displayStats(Map<String, Integer> wordsCounter) {
        for (Map.Entry<String, Integer> entry : wordsCounter.entrySet()) {
            System.out.println(entry.getKey() + "________" + entry.getValue());
        }
    }
}
