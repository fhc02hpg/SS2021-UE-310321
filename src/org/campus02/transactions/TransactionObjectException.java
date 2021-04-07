package org.campus02.transactions;

public class TransactionObjectException extends Exception {

  public TransactionObjectException(String message) {
    super(message);
  }

  public TransactionObjectException(String message, Throwable cause) {
    super(message, cause);
  }

}
