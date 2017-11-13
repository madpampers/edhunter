package ru.edhunter.independent_seatwork.gof_patterns.chain.chain;

public class EmailNotifier extends Notifier {
    public EmailNotifier(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("sending email: " + message);
    }
}
