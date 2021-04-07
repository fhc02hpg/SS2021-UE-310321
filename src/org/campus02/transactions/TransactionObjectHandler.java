package org.campus02.transactions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TransactionObjectHandler {

  public static void saveTransactions(ArrayList<Transaction> transactions, String path)
      throws TransactionObjectException {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
      for (Transaction t : transactions) {
        oos.writeObject(t);
      }
      oos.writeObject(null);
      oos.flush();
    } catch (IOException e) {
      throw new TransactionObjectException("saving to objects file failed", e);
    }
  }

}
