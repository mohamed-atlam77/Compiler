package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader {

    public static List<String> readFile() throws IOException {
        String stringFile = Files.readString(Path.of("..\\test.txt")).stripIndent();
        return List.of(stringFile.split("\n"));
//        return stringFile;

    }

}
