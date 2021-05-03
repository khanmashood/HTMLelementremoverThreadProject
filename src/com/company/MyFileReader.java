package com.company;
//Mashood Khan
//CSC1322 Section 02

import java.util.ArrayList;
import java.util.Scanner;

public class MyFileReader {
    public static ArrayList<String> ScanList(Scanner sr) {

        ArrayList<String> myList = new ArrayList<String>();

        while (sr.hasNextLine()) {
            myList.add(sr.nextLine());
        }

        return myList;
    }

    //Splits the contents of a list into two
    public static void SplitList(ArrayList<String> words, ArrayList<String> list1, ArrayList<String> list2) {

        boolean latter = false;
        for (int i = 0; i < words.size(); i++) {
            if (i == words.size() / 2) {
                latter = true;
            }

            if (latter) {
                list2.add(words.get(i));
            } else {
                list1.add(words.get(i));
            }

        }

    }

}

