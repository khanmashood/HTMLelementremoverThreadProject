package com.company;
import java.util.List;
import java.util.stream.Collectors;
//Mashood Khan
//CSC1322 Section 02

public class HelperClass implements Runnable {
    private List<String> words;

    public HelperClass(List<String> words) {
        this.words = words;
    }

    //function which replaces <>
    public static void ReplaceHTML(List<String> tws1) {

        /* Write your logic to replace the tags and print the text here */

        tws1 = tws1.stream().map(s -> s.replaceAll("\\<.*?>","")).collect(Collectors.toList());
        for(String sentence:tws1) {
            System.out.println(sentence);
        }
    }

    @Override
    public void run() {
        HelperClass.ReplaceHTML(this.words);
    }
}