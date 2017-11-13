package ru.edhunter.independent_seatwork.gof_patterns.chain.chain;

public class SmsNotifier extends Notifier{
    public SmsNotifier(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("Sending sms: " + message);
    }
}
