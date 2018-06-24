package com.ank.java8.stream;

import com.ank.java8.common.Trader;
import com.ank.java8.common.Transaction;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTraderTxnTest {

    public static List<Transaction> getTransactions(){

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        Trader sebastian = new Trader("Sebastian","London");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul,2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950),
                new Transaction(sebastian, 2015, 4200)
        );

        return transactions;
    }

    public static void main(String[] args) {

        List<Transaction> transactions = getTransactions();

        // transactions in year 2011 and sorted by value
        List<Transaction> tr2011 = transactions.stream()
                                                .filter(t -> t.getYear() == 2011)
                                                .sorted(Comparator.comparing(Transaction::getValue))
                                                .collect(Collectors.toList());

        System.out.println("tr2011 = " + tr2011);

        // unique cities where the traders work

        List<String> uniqueCities = transactions.stream()
                                                .map(t -> t.getTrader().getCity())
                                                .distinct()
                                                .collect(Collectors.toList());

        System.out.println("uniqueCities = " + uniqueCities);
        
        // traders from Cambridge sorted by name
        
        List<Trader> cambridgeTraders = transactions.stream()   
                                                    .map(Transaction::getTrader)
                                                    .filter(t -> t.getCity().equals("Cambridge"))
                                                    .distinct()
                                                    .sorted(Comparator.comparing(Trader::getName))
                                                    .collect(Collectors.toList());

        System.out.println("cambridgeTraders = " + cambridgeTraders);

        // All traders sorted alphabetically in a string
        String traderNamesSorted = transactions.stream()
                                                    .map(Transaction::getTrader)
                                                    .map(Trader::getName)
                                                    .distinct()
                                                    .sorted()
                                                    .collect(Collectors.joining(","));

        System.out.println("traderNamesSorted = " + traderNamesSorted);
        
        String traderNamesSorted2 = transactions.stream()   
                        .map(transaction -> transaction.getTrader().getName())
                        .distinct()
                        .sorted()
                        .reduce("", (n1, n2) -> n1+n2 );

        System.out.println("traderNamesSorted2 = " + traderNamesSorted2);

        // traders from Milan
        List<Trader> tradersFromMilan = transactions.stream()
                                                    .map(Transaction::getTrader)
                                                    .filter(trader -> trader.getCity().equals("Milan"))
                                                    .distinct()
                                                    .collect(Collectors.toList());

        System.out.println("tradersFromMilan = " + tradersFromMilan);

        // approach 2 : traders from Milan
        boolean anyTraderFromMilan = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));

        System.out.println("anyTraderFromMilan = " + anyTraderFromMilan);
        
        boolean anyTraderFromIndia = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("India"));

        System.out.println("anyTraderFromIndia = " + anyTraderFromIndia);

        // Transaction values from traders living in Cambridge
        List<Transaction> txnFromCambridgeTraders = transactions.stream()
                                                        .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                                                        .collect(Collectors.toList());

        System.out.println("txnFromCambridgeTraders = " + txnFromCambridgeTraders);


        // Highest Value of all the transaction
        Optional<Integer> highestTransactionValue = transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce(Integer::max);

        System.out.println("highestTransactionValue = " + highestTransactionValue);
        
        //Smallest value of all the transaction
        Optional<Integer> lowestTransactionValue = transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce(Integer::min);

        System.out.println("lowestTransactionValue = " + lowestTransactionValue);

        // approach 2 : Smallest value of all the transaction
        Optional<Transaction> lowestTransaction2 = transactions.stream()
                    .reduce((t1,t2) -> t1.getValue() < t2.getValue() ? t1 : t2);

        System.out.println("lowestTransaction2 = " + lowestTransaction2);
        
        // approach 3 : Smallest value of all the transaction
        Optional<Transaction> smallestTransaction = transactions.stream()
                    .min(Comparator.comparing(Transaction::getValue));

        System.out.println("smallestTransaction = " + smallestTransaction);
        
    }
}
