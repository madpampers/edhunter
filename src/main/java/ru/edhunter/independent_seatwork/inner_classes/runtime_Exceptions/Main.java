package ru.edhunter.independent_seatwork.inner_classes.runtime_Exceptions;

import ru.edhunter.independent_seatwork.inner_classes.BankAccount;

public class Main {
    private static BankAccount bankAccount = new BankAccount("Andrey");
    private static BankAccount.DepositCard andreyCard = bankAccount.new DepositCard("Andrey");

    public static void main(String[] args) {
        System.out.println(andreyCard.getBalance());
        andreyCard.deposit(1000);
        System.out.println(andreyCard.getBalance());
        andreyCard.withdraw(500);
        System.out.println(andreyCard.getBalance());
        System.out.println(andreyCard.getAccountOwner());
        System.out.println(andreyCard.getCardNumber());
        try{
        andreyCard.withdraw(5000);}
        catch (InvalidOperationException e) {
            System.out.println("Ошибка! На вашем счете недостаточно средств");
        }
    }
}
