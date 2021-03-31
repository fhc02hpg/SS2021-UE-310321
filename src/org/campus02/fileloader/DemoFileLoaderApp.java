package org.campus02.fileloader;

import java.util.Scanner;

public class DemoFileLoaderApp {
    public static void main(String[] args) {

/*
        TextFileLoader textFileLoader = new TextFileLoader("D:\\temp\\er hörte leise.txt");

        try {
            textFileLoader.loadFile();
        } catch (GenericFileLoadException e) {
            e.printStackTrace();
        }

        System.out.println(GenericFileLoader.CountBytes);


        BinaryFileLoader binaryFileLoader =
                new BinaryFileLoader("D:\\temp\\jre-8u281-windows-x64.exe");
        try {
            binaryFileLoader.loadFile();
        } catch (GenericFileLoadException e) {
            e.printStackTrace();
        }

        System.out.println("GenericFileLoader.CountBytes = "
                + GenericFileLoader.CountBytes);

 */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bitte Pfad eingeben: ");
        String path = scanner.nextLine();
        System.out.print("Bitte Dateien, getrennt durch ; eingeben: ");
        String files = scanner.nextLine();

        String[] fileArr = files.split(";");

        for(String file : fileArr) {
            System.out.println("verarbeite Datei " + file);
            String ext = file.substring(file.length() - 3);

            //String[] arr = file.split("\\.");
            //System.out.println(arr[arr.length - 1]);
            try
            {
                if (ext.equals("txt")) {
                    TextFileLoader tfl = new TextFileLoader(path + file);
                    tfl.loadFile();
                }
                else {
                    BinaryFileLoader bfl = new BinaryFileLoader(path + file);
                    bfl.loadFile();
                }
            }catch(GenericFileLoadException ex){
                ex.printStackTrace();
            }
            System.out.println("GenericFileLoader.CountBytes = " + GenericFileLoader.CountBytes);
        }
    }
}
