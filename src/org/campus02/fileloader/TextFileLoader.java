package org.campus02.fileloader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class TextFileLoader extends GenericFileLoader
            implements Runnable
{

    private ArrayList<String> content = new ArrayList<>();
    private HashMap<Character, Integer> countVowels = new HashMap<>();

    public TextFileLoader(String path) {
        super(path);
    }

    public ArrayList<String> getContent() {
        return content;
    }

    public HashMap<Character, Integer> getCountVowels() {
        return countVowels;
    }

    @Override
    public void loadFile() throws GenericFileLoadException {
        /*
        try (FileReader fr = new FileReader(path)) {
            int byteRead;
            while ((byteRead = fr.read()) != -1){
                CountBytes++;
            }

        } catch (FileNotFoundException e) {
            throw new GenericFileLoadException("Fehler beim Laden von: " + path, e);
        } catch (IOException e) {
            throw new GenericFileLoadException("Fehler beim Laden von: " + path, e);
        }
    */

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null) {

                incrementCountBytes(line.length());
                incrementCountBytes(1);
//                CountBytes += line.length();
//                CountBytes++;

                for (char c : line.toLowerCase(Locale.ROOT).toCharArray()) {
                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){

                        if (countVowels.containsKey(c)) {
                            //int currentValue = countVowels.get(c);
                            //currentValue++;
                            //countVowels.put(c, currentValue);

                            countVowels.put(c, countVowels.get(c) + 1);
                        }
                        else {
                            countVowels.put(c, 1);
                        }
                    }
                }

                content.add(line);
            }

        } catch (FileNotFoundException e) {
            throw new GenericFileLoadException("Fehler beim Laden von: " + path, e);
        } catch (IOException e) {
            throw new GenericFileLoadException("Fehler beim Laden von: " + path, e);
        }
    }

    @Override
    public void run() {
        try {
            loadFile();
        } catch (GenericFileLoadException e) {
            e.printStackTrace();
        }
    }
}
