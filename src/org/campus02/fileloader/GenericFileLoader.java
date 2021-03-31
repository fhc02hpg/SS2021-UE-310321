package org.campus02.fileloader;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class GenericFileLoader {

    protected String path;

    public static int CountBytes;
    protected static Lock lockObject = new ReentrantLock();

    protected static void incrementCountBytes(int value) {
        lockObject.lock();
        CountBytes += value;
        lockObject.unlock();
    }

    public GenericFileLoader(String path) {
        this.path = path;
    }

    public abstract void loadFile() throws GenericFileLoadException;
}
