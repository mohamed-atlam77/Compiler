package org.example;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        String str = scan.nextLine();
        System.out.println(LexicalAnalyzer.lexicalAnalyze(str));
    }
}