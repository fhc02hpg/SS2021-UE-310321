package org.campus02.fileloader;

public abstract class GenericFileLoader {

    protected String path;

    public static int CountBytes;

    public GenericFileLoader(String path) {
        this.path = path;
    }

    public abstract void loadFile() throws GenericFileLoadException;
}
