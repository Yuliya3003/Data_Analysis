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
        HashMap<String, Integer> fruits = frequencyOfOccurrence(words);
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
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
        return words;
    }

    public static int countSize(ArrayList<String> list){
        return list.size();
    }

    public static ArrayList<String> findLongestWords(ArrayList<String> list){
        ArrayList<String> longestWords = new ArrayList<>();
        int maxLength = 0;
        for (String word : list) {
            int length = word.length();
            if (length > maxLength) {
                maxLength = length;
                longestWords.clear();
                longestWords.add(word);
            } else if (length == maxLength && !longestWords.contains(word)) {
                longestWords.add(word);
            }
        }
        return longestWords;
    }

    public static HashMap<String, Integer> frequencyOfOccurrence(ArrayList<String> list){
        HashMap<String, Integer> fruitFrequency = new HashMap<>();
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
