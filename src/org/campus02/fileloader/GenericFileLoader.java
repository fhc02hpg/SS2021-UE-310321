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

    protected static Object lock2 = new Object();
    protected static void incrementCountBytes2(int value) {
        synchronized (lock2) {
            CountBytes += value;
        }
    }

    public GenericFileLoader(String path) {
        this.path = path;
    }

    public abstract void loadFile() throws GenericFileLoadException;
}
