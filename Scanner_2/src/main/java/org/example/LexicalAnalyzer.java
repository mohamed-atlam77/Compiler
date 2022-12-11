package org.example;

import java.util.regex.Pattern;

public class LexicalAnalyzer {
    static String letter = "[a-zA-Z]";
    static String digit = "[\\d]";

    // identifier: should start with a letter and consists of _, digit or letters
    static String identifier = letter + "[" + letter + "_" + digit + "]+";  // [a-zA-Z][a-z_A-Z\\d]
    static String keyword ="(float|int|String|void|if|else|while|break|function)";
    static String specialCharacter = "[!,?._'@]+";
    static String intNum = digit + "+";
    static String floatNum = intNum + "\\." + digit + "*";
    static String arithmeticOperator = "\\+|\\-|\\*|\\/";
    static String assignment = "=";
    static String comparisonOperator = "==|>|<|>=|<=|!=";
    static String semicolon = ";";

    static String singleLineComment = "[/][/].*";
    static String multiLineComments = "[/][*].*[*][/]";  // (\\d|\\D)
    static String whiteSpaces = "[\\s]";

    public static TokenClass lexicalAnalyze(String str) {

        if(Pattern.matches(keyword, str)) return TokenClass.KEYWORD;
        else if(Pattern.matches(identifier, str)) return TokenClass.IDENTIFIER;
        else if(Pattern.matches(specialCharacter, str)) return TokenClass.SPECIAL_CHARACTER;
        else if(Pattern.matches(intNum, str)) return TokenClass.INTEGER;
        else if(Pattern.matches(floatNum, str)) return TokenClass.FLOAT;
        else if(Pattern.matches(arithmeticOperator, str)) return TokenClass.ARITHMETIC_OPERATOR;
        else if(Pattern.matches(comparisonOperator, str)) return TokenClass.COMPARISON_OPERATOR;
        else if(Pattern.matches(assignment, str)) return TokenClass.ASSIGNMENT_OPERATOR;
        else if(Pattern.matches(semicolon, str)) return TokenClass.SEMICOLON;
        return TokenClass.INVALID;
    }
}