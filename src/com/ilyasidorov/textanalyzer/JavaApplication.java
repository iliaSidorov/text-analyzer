package com.ilyasidorov.textanalyzer;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class JavaApplication {

    static String absoluteFilePath = "E:\\projects\\text-analizer\\src\\com\\ilyasidorov\\textanalyzer\\file.txt";
    static String relativeFilePath = "src/com/ilyasidorov/textanalyzer/file.txt";

    public static void main(String[] args) {
        TextFromFileAnalyzer analyzer = new TextFromFileAnalyzer();

        try {
            analyzer.analyze(absoluteFilePath);
        } catch (NoSuchFileException e) {
            System.out.println("Couldn't find your file, man. Check your path and try it again");
        } catch (IOException e) {
            System.out.println("Something wrong with IO");
            e.printStackTrace();
        }

    }

}
