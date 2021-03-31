package org.campus02.fileloader;

public class DemoFileLoaderApp {
    public static void main(String[] args) {


        TextFileLoader textFileLoader = new TextFileLoader("D:\\temp\\er hörte leise.txt");

        try {
            textFileLoader.loadFile();
        } catch (GenericFileLoadException e) {
            e.printStackTrace();
        }

        System.out.println(GenericFileLoader.CountBytes);
    }
}
