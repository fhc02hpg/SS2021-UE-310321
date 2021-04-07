package org.campus02.transactions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TransactionManager {

  private ArrayList<Transaction> transactions;

  public TransactionManager(ArrayList<Transaction> transactions) {
    this.transactions = transactions;
  }

  public HashMap<String, Integer> getTransactionCountByCity() {
    HashMap<String,Integer> result = new HashMap<>();

    for(Transaction t : transactions) {
      if(result.containsKey(t.getCity())) {
        result.put(t.getCity(),result.get(t.getCity())+1);
      } else {
        result.put(t.getCity(),1);
      }
    }
    return result;
  }

  public Integer getCountOfTransaction(String country) {
    int count = 0;
    for(Transaction t : transactions) {
      if(t.getCountry().equals(country)) {
        count++;
      }
    }
    return count;
  }

  public ArrayList<Transaction> getTransactionsToProduct(String product) {
    ArrayList<Transaction> found = new ArrayList<>();
    for(Transaction t : transactions) {
      if(t.getProduct().equals(product)) {
        found.add(t);
      }
    }
    return found;
  }

  public HashMap<String, Double> getAverageTransactionAmountByPaymentType() {
    HashMap<String, Double> mapSum = new HashMap<>();
    for(Transaction t : transactions) {
      if(mapSum.containsKey(t.getPaymentType())) {
        mapSum.put(t.getPaymentType(),mapSum.get(t.getPaymentType())+t.getPrice());
      } else {
        mapSum.put(t.getPaymentType(),t.getPrice());
      }
    }

    HashMap<String, Integer> mapCount = getTransactionCountByPaymentType();

    HashMap<String, Double> mapAvg = new HashMap<>();
    for(Map.Entry<String,Double> e : mapSum.entrySet()) {
      mapAvg.put(e.getKey(),e.getValue() / mapCount.get(e.getKey()));
    }

    return mapAvg;
  }

  public HashMap<String, Integer> getTransactionCountByPaymentType() {
    HashMap<String,Integer> result = new HashMap<>();
    for(Transaction t : transactions) {
      if(result.containsKey(t.getPaymentType())) {
        result.put(t.getPaymentType(),result.get(t.getPaymentType())+1);
      } else {
        result.put(t.getPaymentType(),1);
      }
    }
    return result;
  }


}
