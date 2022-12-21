package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.example.LexicalAnalyzer.*;


public class DeclarationAndInit_Validation {
// ------------variable declaration and initialization------------
// "int|float([\\s]?)" + id = "[+-]?" + integerValue|floatValue + "([+-/*][ ]?[\\d+])?" + semicolon

    //"([\\d]+|[\\d\\.\\d*])"
    static String declarationForm = "(int|float)(\\s)*" +"(" + identifier +")"+ "(\\s)*";
    static String initializationForm = "\\s*" + "[+-]?" + "\\s*" + "(" + intNum +"|"+ floatNum + ")\\s*";
    static String optionalPart = "(["+arithmeticOperator+"](\\s)*"+"["+initializationForm+"]"+")*" + "\\s*";
    static String generalForm = declarationForm + assignment + initializationForm + optionalPart+ semicolon;
    static List<String> initializedVariables = new ArrayList<>();

    public static List<String> isValid(String line){
        List<String> lst = List.of(line.split("[=;\\s]+"));
        int countKeywords = (int) lst.stream().filter(s -> Pattern.matches(keyword, s)).count();
//        lst.forEach(System.out::println);
        boolean isMatched = Pattern.matches(generalForm, line);
        if(isMatched && countKeywords==1) System.out.println("This declaration and initialization part is VALID");
        else System.out.println("This declaration and initialization part is INVALID");
        return initializedVariables;
    }
}
