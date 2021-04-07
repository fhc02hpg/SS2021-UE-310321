package org.campus02.transactions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionDemoApp {
    public static void main(String[] args) {

        String path = "data/transactions.csv";

        try {
            ArrayList<Transaction> transactions =
                    TransactionLoader.loadTransactions(path);

            Collections.sort(transactions, new PriceProductComparator());

            /*
            for (Transaction t : transactions) {
                System.out.println(t);
            }
            */

            TransactionObjectHandler.saveTransactions(transactions,"data/transactions.obj");

            TransactionManager tm = new TransactionManager(transactions);
            System.out.println("US transaction count: "+
                tm.getCountOfTransaction("United States"));
            System.out.println("Denmark transaction count: "+
                tm.getCountOfTransaction("Denmark"));

            List<Transaction> productTransactions = tm.getTransactionsToProduct("Product2");
            System.out.println("transaction list Product2: "+productTransactions);
            System.out.println("count: "+productTransactions.size());

            System.out.println("transactions by city: "+tm.getTransactionCountByCity());

            System.out.println("avg amount per payment type:"+tm.getAverageTransactionAmountByPaymentType());

        } catch (LoadException | TransactionObjectException e) {
            e.printStackTrace();
        }

    }
}
