package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        List<String> code = new ArrayList<>();
        try {
            code = FileReader.readFile();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        code = SingleLineComment.remove(code);
        code = MultiLineComment.remove(code);
        code = EmptyLine.remove(code);

        code.forEach(System.out::println);

        /*
        ------------variable declaration and initialization------------
        "int|float([\\s]?)" + id = "[+-]?" + integerValue|floatValue + "([+-/*][ ]?[\\d+])?" + semicolon
        ------------Conditional Statement (if-statement)------------
        // Note that id1 and id2 must be declared and initialized before.
        // if not declared and initialized it will throw an error
        "if" +"\\s"+ "(" + "\\s" + "(id|[\\d]+)" + "\\s" + comparisonOperator + "(id|[\\d]+)" + "\\s" + ")"
        */

        for(int i=0; i< code.size(); i++){
            String line = code.get(i);
            if(line.startsWith("int") || line.startsWith("float")){
                DeclarationAndInit_Validation.isValid(line);
            } else if (line.startsWith("if")) {
                ConditionalStatementValidation.isValid(line);
            }
        }

    }
}