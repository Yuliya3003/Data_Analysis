package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FruitManager {
    public static void main(String[] args) {
        ArrayList<String> words = readTxt("input.txt");
        System.out.println("В файле " + countSize(words)+ " слов.");
        System.out.print("Список самых длинных слов: ");
        for (String elem:findLongestWords(words)
             ) {
            System.out.print(elem+ " ");
        }
        System.out.println();
        System.out.println("Частота встречаемости слов: ");
        TreeMap<String, Integer> fruits = frequencyOfOccurrence(words);
        for (Map.Entry<String, Integer> entry : fruits.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }

    public static ArrayList<String> readTxt(String fileName){
       ArrayList<String> words = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] tokens = line.split("\\s+");
                    words.addAll(Arrays.asList(tokens));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    public static int countSize(ArrayList<String> list){
        return list.size();
    }

    public static ArrayList<String> findLongestWords(ArrayList<String> list){
        String longest = list.get(0);
        ArrayList<String> longestWords = new ArrayList<>();
        Set<String> uniqueWords = new HashSet<>(list);
        for (String elem:uniqueWords
             ) {
            if (longest.length() < elem.length()){
                longest = elem;
            }
        }
        for (String elem:uniqueWords
             ) {
            if (elem.length() == longest.length()){
                longestWords.add(elem);
            }
        }
        return longestWords;
    }

    public static TreeMap<String, Integer> frequencyOfOccurrence(ArrayList<String> list){
        TreeMap<String, Integer> fruitFrequency = new TreeMap<>();
        for (String fruit:list
             ) {
            if (fruitFrequency.containsKey(fruit)){
                fruitFrequency.put(fruit, fruitFrequency.get(fruit)+1);
            } else {
                fruitFrequency.put(fruit, 1);
            }
        }
        return fruitFrequency;
    }
}
