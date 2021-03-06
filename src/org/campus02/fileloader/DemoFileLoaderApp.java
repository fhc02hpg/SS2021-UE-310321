package org.campus02.fileloader;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DemoFileLoaderApp {
    public static void main(String[] args) throws InterruptedException {


        TextFileLoader textFileLoader = new TextFileLoader("D:\\temp\\er hörte leise.txt");

        try {
            textFileLoader.loadFile();
        } catch (GenericFileLoadException e) {
            e.printStackTrace();
        }

        System.out.println(GenericFileLoader.CountBytes);

        System.out.println("textFileLoader = " + textFileLoader.getCountVowels());

/*
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
        //"er hörte leise.txt;text.txt;products.dat;jre-8u281-windows-x64.exe"
        String files = scanner.nextLine();

        String[] fileArr = files.split(";");
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ArrayList<Thread> threads = new ArrayList<>();
        for (String file : fileArr) {
            System.out.println("verarbeite Datei " + file);
            String ext = file.substring(file.length() - 3);

            //String[] arr = file.split("\\.");
            //System.out.println(arr[arr.length - 1]);

            if (ext.equals("txt")) {
                TextFileLoader tfl = new TextFileLoader(path + file);
                //executorService.execute(tfl);

                Thread th = new Thread(tfl);
                th.start();
                threads.add(th);
            } else {
                BinaryFileLoader bfl = new BinaryFileLoader(path + file);
                //executorService.execute(bfl);
                Thread th = new Thread(bfl);
                th.start();
                threads.add(th);
            }

            System.out.println("GenericFileLoader.CountBytes = " + GenericFileLoader.CountBytes);
        }

        for(Thread th : threads) {
            try {
                th.join();
                System.out.println("Dieser Thread is fertig: " + th.getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //executorService.shutdown();
        //executorService.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("Total: CountBytes = " + GenericFileLoader.CountBytes);
    }
}
