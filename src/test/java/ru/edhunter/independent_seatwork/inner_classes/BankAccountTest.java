package ru.edhunter.independent_seatwork.inner_classes;

import org.junit.*;
import ru.edhunter.independent_seatwork.inner_classes.runtime_Exceptions.InvalidOperationException;

public class BankAccountTest {
    private static BankAccount bankAccount;
    private static BankAccount.DepositCard valdemarCard;
    private static BankAccount.DepositCard bettyCard;

    @Before
    public void prepareTest() {
        bankAccount = new BankAccount("Вальдемар");
        valdemarCard = bankAccount.new DepositCard("Вальдемар");
        bettyCard = bankAccount.new DepositCard("Бетти");
    }

    @Test
    public void depositCardsTest() throws InvalidOperationException {
        Assert.assertEquals(valdemarCard.getAccountId(), bettyCard.getAccountId());
        Assert.assertEquals(valdemarCard.getAccountOwner(), bettyCard.getAccountOwner());
        Assert.assertEquals(valdemarCard.getCardOwner(), "Вальдемар");

        Assert.assertNotEquals(valdemarCard.getCardNumber(), bettyCard.getCardNumber());
        Assert.assertNotEquals(bettyCard.getCardOwner(), valdemarCard.getCardOwner());

        valdemarCard.deposit(2000);

        Assert.assertEquals(2000, valdemarCard.getBalance());
        Assert.assertEquals(valdemarCard.getBalance(), bettyCard.getBalance());

        bettyCard.credit(500);

        Assert.assertEquals(1500, valdemarCard.getBalance());
    }

    @Test(expected = InvalidOperationException.class)
    public void exceptionNegativeBalanceTest() {
        bettyCard.credit(500);
    }

//    @Test(expected = NoSuchCardException.class)
//    public void noSuchCardByName() {
//        bankAccount.getCard("Рогалик");
//    }
//
//    @Test(expected = NoSuchCardException.class)
//    public void noSuchCardByID() {
//        bankAccount.getCard(234234234);
//    }
}
