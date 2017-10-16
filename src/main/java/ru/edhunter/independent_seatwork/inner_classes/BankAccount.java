package ru.edhunter.independent_seatwork.inner_classes;

import ru.edhunter.independent_seatwork.inner_classes.runtime_Exceptions.InvalidOperationException;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BankAccount {
    private final String owner;
    private final int id;
    private int balance = 0;
    private Map<String, DepositCard> cards = new HashMap<>();

    public BankAccount(final String owner) {
        Random random = new Random();
        this.owner = owner;
        this.id = Math.abs(random.nextInt());
    }

    private void put(final DepositCard card) {
        cards.put(card.owner, card);
    }

//    public DepositCard getCard(final String owner) {
//        DepositCard resultCard = cards.get(owner);
//        if (resultCard == null) throw new NoSuchCardException();
//        return resultCard;
//    }
//
//    public DepositCard getCard(final int id){
//        DepositCard resultCard = null;
//        for(Map.Entry<String, DepositCard> entry: cards.entrySet()) {
//            if(entry.getValue().number == id) resultCard = cards.get(entry.getKey());
//        }
//        if (resultCard == null) throw new NoSuchCardException();
//        return resultCard;
//    }

    public class DepositCard {
        private final String owner;
        private final int number;

        public DepositCard(final String owner) {
            Random random = new Random();
            this.owner = owner;
            this.number = Math.abs(random.nextInt());
            BankAccount.this.put(this);
        }

        public void deposit(final int amount) {
            BankAccount.this.balance = BankAccount.this.balance + amount;
        }

        public void withdraw(final int amount) throws InvalidOperationException {
            if (BankAccount.this.balance - amount < 0) throw new InvalidOperationException();
            BankAccount.this.balance = BankAccount.this.balance - amount;
        }

        public int getBalance() {
            return BankAccount.this.balance;
        }

        public int getAccountId() {
            return BankAccount.this.id;
        }

        public String getAccountOwner() {
            return BankAccount.this.owner;
        }

        public int getCardNumber() {
            return number;
        }

        public String getCardOwner() {
            return owner;
        }
    }
}
