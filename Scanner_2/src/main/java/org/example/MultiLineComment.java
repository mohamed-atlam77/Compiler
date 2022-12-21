package org.example;

import java.util.ArrayList;
import java.util.List;

public class MultiLineComment {
    static List<String> newCode = new ArrayList<>();
    public static List<String> remove(List<String> code) throws Exception {
        for(int i=0; i< code.size(); i++){
            String line = code.get(i).trim();

            if(line.contains("/*") && line.contains("*/")){
                int commentBegin = line.indexOf("/*");
                int commentEnd = line.indexOf("*/");
                line = line.substring(0,commentBegin).trim() +
                        " " + line.substring(commentEnd+2).trim();
                if(line.trim()!="")
                    newCode.add(line);
            }
            else if(line.contains("/*") && !line.contains("*/")){
                int startOfMultiLineComment = line.indexOf("/*");
                line = line.substring(0,startOfMultiLineComment).trim();
                boolean lineBeforeCommentContainsSemicolon = line.contains(";");
                if(lineBeforeCommentContainsSemicolon)
                    newCode.add(line);
                String lineBeforecomment =line;
                i++;
                line = code.get(i).trim();
                while(!line.contains("*/")){
                    if(i== code.size()){
                        throw new Exception("There is */ missed in your code after this line>> " + line);
                    }
                    line = code.get(++i).trim();
                }
                int endOfMultiLineComment = line.indexOf("*/");
                line = line.substring(endOfMultiLineComment+2).trim();
                if(line!=""){
                    if(lineBeforeCommentContainsSemicolon){
                        line = lineBeforecomment.trim() + " " + line;
                    }
                    newCode.add(line);
                }

            }
            else if(line.contains("*/")){
                throw new Exception("There is /* missed in your code before this line>> " + line);
            }
            else {
                newCode.add(line);
            }

        }

//        newCode.forEach(System.out::println);
        return newCode;
    }
}
