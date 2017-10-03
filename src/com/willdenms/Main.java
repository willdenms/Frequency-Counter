package com.willdenms;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Hashtable<String, Integer> wordFreq = new Hashtable<>();
        List<String> wordList = new ArrayList<>();
        String masterList = "";

        String fileName = "/Users/willdenms/Desktop/Frequency Counter/words";

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            wordList = stream
                        .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < wordList.size(); i++){
            masterList += wordList.get(i);
        }

        for(String word : masterList.split(" ")) {

            if(wordFreq.containsKey(word.toLowerCase())) {
                Integer temp = wordFreq.get(word.toLowerCase());
                temp++;
                wordFreq.put(word.toLowerCase(), temp);
            }
            else {
                wordFreq.put(word.toLowerCase(), 1);
            }
        }


//        for(String key : wordFreq.keySet()) {
//            System.out.println(key + ": " + wordFreq.get(key));
//        }

        sortValue(wordFreq);


    }

    public static void sortValue(Hashtable<String, Integer> t) {

        ArrayList<Map.Entry<?, Integer>> l = new ArrayList(t.entrySet());
        Collections.sort(l, new Comparator<Map.Entry<?, Integer>>(){

            public int compare(Map.Entry<?, Integer> o1, Map.Entry<?, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }});

        System.out.println(l);

    }
}
