package org.example;

import java.util.ArrayList;
import java.util.List;

public class SingleLineComment {
    static List<String> newCode = new ArrayList<>();
    public static List<String > remove(List<String> code){
        for(int i=0; i< code.size(); i++){
            String line = code.get(i).trim();
            if(line.contains("//")){
                int startOfSingleLineComment = line.indexOf("//");
                line = line.substring(0, startOfSingleLineComment);
                if(line!="")
                    newCode.add(line);
            }
            else newCode.add(line);
        }
        return newCode;
    }
}

