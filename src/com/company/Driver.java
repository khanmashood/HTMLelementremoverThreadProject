package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Mashood Khan
//CSC1322 Section 02
public class Driver {




    public static void main(String[] args) throws FileNotFoundException {
        //Reading the file and spliting it into 2 lists.
        File file = new File("");
        Scanner s = new Scanner(file);
        ArrayList<String> words = MyFileReader.ScanList(s);
        ArrayList<String> List1 = new ArrayList<>();
        ArrayList<String> List2 = new ArrayList<>();
        MyFileReader.SplitList(words,List1,List2);
        List[] newList = {List1,List2};

        //Setting up threads to do the replacing.

        HelperClass tws1 = new HelperClass(newList[0]);
        HelperClass tws2 = new HelperClass(newList[1]);
        int choice=1;
        Scanner myObj = new Scanner(System.in);
        do
        {
            System.out.println("Choose the function you would like to run:\n1-No Thread Test\n2-Thread Test");
            choice = myObj.nextInt();
            switch (choice) {
                case 1:
                    NoThreadTest(newList[0],newList[1]);
                    break;
                case 2:
                    ThreadTest(tws1, tws2);
                    break;
            }
            System.out.println("Enter 0 to exit any other key to continue");
            choice = myObj.nextInt();

        }while(choice!=0);

        s.close();
    }

    //Removes the html characters without using threads.
    private static void NoThreadTest(List<String> tws1, List<String> tws2) {
        //start timer
        long startTime = System.currentTimeMillis();
        System.out.println("Replacing html");
        HelperClass.ReplaceHTML(tws1);
        HelperClass.ReplaceHTML(tws2);
        //stop times
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Without Thread Runtime in miliseconds: "+elapsedTime);
    }

    //Removes the html characters using threads.
    private static void ThreadTest(HelperClass tws1, HelperClass tws2) {
        //start timer
        long startTime = System.currentTimeMillis();
        //Write your code to use threads here

        Thread tw1 = new Thread(tws1);
        Thread tw2 = new Thread(tws2);
        System.out.println("Replacing html");
        tw1.start();
        tw2.start();
        try {
            tw1.join();
            tw2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println("Thread Runtime in miliseconds: " + elapsedTime);

        }

    }



