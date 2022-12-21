package org.example;

import java.util.List;
import java.util.regex.Pattern;

import static org.example.LexicalAnalyzer.*;
public class ConditionalStatementValidation {

    // Note that id1 and id2 must be declared and initialized before.
    // if not declared and initialized it will throw an error
    // "if" +"\\s"+ "(" + "\\s" + "(id|[\\d]+)" + "\\s" + comparisonOperator + "(id|[\\d]+)" + "\\s" + ")"
    static String leftOrRightParam = "(" + identifier + "|" + intNum +"|"+ floatNum + ")";
    static String condition = leftOrRightParam + "(\\s)*" + "(" + comparisonOperator +")"+ "(\\s)*" + leftOrRightParam;
    static String generalForm = "if" + "(\\s)*" + "[(](\\s)*" + condition + "(\\s)*[)]";
    public static List<String> isValid (String line){
        List<String> lst = List.of(line.split("["+ comparisonOperator+ ")(\\s]+"));
//        lst.forEach(System.out::println);
        int countKeywords = (int) lst.stream().filter(s -> Pattern.matches(keyword, s)).count();
        boolean isMatched = Pattern.matches(generalForm, line);
        if(isMatched && countKeywords==1) System.out.println("This Conditional Statement is VALID");
        else System.out.println("This Conditional Statement is INVALID");
        return null;
    }
}
