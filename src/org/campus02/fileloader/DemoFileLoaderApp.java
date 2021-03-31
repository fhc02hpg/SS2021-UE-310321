package org.campus02.fileloader;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        // Liste von Threads erstellen

        ArrayList<Thread> threads = new ArrayList<>();
        for (String file : fileArr) {
            System.out.println("verarbeite Datei " + file);
            String ext = file.substring(file.length() - 3);

            //String[] arr = file.split("\\.");
            //System.out.println(arr[arr.length - 1]);

            if (ext.equals("txt")) {
                TextFileLoader tfl = new TextFileLoader(path + file);
                Thread th = new Thread(tfl);
                th.start();
                threads.add(th);
            } else {
                BinaryFileLoader bfl = new BinaryFileLoader(path + file);
                Thread th = new Thread(bfl);
                th.start();
                threads.add(th);
            }

            System.out.println("GenericFileLoader.CountBytes = " + GenericFileLoader.CountBytes);
        }

        // .join()
        for(Thread th : threads) {
            try {
                th.join();
                System.out.println("Dieser Thread is fertig: " + th.getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Total: CountBytes = " + GenericFileLoader.CountBytes);
    }
}
