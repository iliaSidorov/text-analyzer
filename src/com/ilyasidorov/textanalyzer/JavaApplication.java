package com.ilyasidorov.textanalyzer;

import java.io.IOException;

public class JavaApplication {

    static String filePath = "E:\\projects\\text-analizer\\src\\com\\ilyasidorov\\textanalyzer\\file.txt";

    public static void main(String[] args) throws IOException {
        TextFromFileAnalyzer analyzer = new TextFromFileAnalyzer();

        analyzer.analyze(filePath);

    }





}
