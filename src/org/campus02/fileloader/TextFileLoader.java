package org.campus02.fileloader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextFileLoader extends GenericFileLoader {


    public TextFileLoader(String path) {
        super(path);
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
                CountBytes += line.length();
                CountBytes++;
            }

        } catch (FileNotFoundException e) {
            throw new GenericFileLoadException("Fehler beim Laden von: " + path, e);
        } catch (IOException e) {
            throw new GenericFileLoadException("Fehler beim Laden von: " + path, e);
        }
    }
}
