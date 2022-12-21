package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmptyLine {
    static List<String> newCode = new ArrayList<>();
    public static List<String> remove(List<String> code){

        newCode =code.stream()
                .filter(s -> !(s.trim().equals("")))
                .map(s -> s.trim())
                .collect(Collectors.toList());

//        newCode.forEach(System.out::println);
        return newCode;
    }
}
